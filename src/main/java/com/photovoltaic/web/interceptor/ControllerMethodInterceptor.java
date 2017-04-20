package com.photovoltaic.web.interceptor;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.constants.WebConstants;
import com.photovoltaic.commons.util.WebUtils;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.BaseInModel;
import com.photovoltaic.web.model.in.auth.LoginInModel;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 拦截器：统一检查authcode和userToken，记录接口调用日志
 * 
 * @author wushenjun
 * 
 */
public class ControllerMethodInterceptor extends BaseInterceptor implements MethodInterceptor {
	
	
	
	/**
	 * 拦截Controller中的方法，处理一些公共逻辑： 
	 * 1、对于用Map接收参数的，检查其中的authcode、userToken是否有效
	 * 2、对于不用Map接收数据的，需要自己在service中检查authcode和userToken
	 * 3、对于用Map接收参数，又不需要检查userToken的 （比如login），需要为方法添加注解@LoginNotRequired
	 * 4、统一捕获异常，并返回ReturnCode.EXCEPTION给前端
	 * 5、记录接口调用日志：数据库记录会截取超长参数，文本log会抛弃图片的base64编码
	 * 
	 * @author shenjun
	 * @param invocation 被拦截的方法
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//long beginTime = System.currentTimeMillis();
		String userIdInt = "-1"; //缺省的userId
		String userId=null;
		//TabUserOpLog userOpLog = new TabUserOpLog();
		
		Set<Object> allParams = new LinkedHashSet<>(); //保存到文件中的所有原始的请求参数
		
		Method method = invocation.getMethod();
		String methodName = method.getName();
		/*userOpLog.setMethod(methodName);
		userOpLog.setCtime(beginTime/1000);*/
		
		logger.debug("请求开始，方法：{}", methodName);

		Object result = null;
		
		final Object[] args = invocation.getArguments();
		if (args != null && args.length != 0) {
			for (Object arg : args) {
				if (arg instanceof Map<?, ?>) {
					@SuppressWarnings("unchecked")
					Map<String, Object> map = (Map<String, Object>) arg;

					// 检查authcode是否正确
					if(!verifyAuthCode(method, map)){
						logger.info("秘钥验证不通过!");
						result = new JsonResultOut(ReturnCode.ERROR, "秘钥验证不通过！", null);
						//break; //继续走，抓取参数到log
					}
					
					//登录接口，用其他方法获取userId，如果获取不到则为“-1”
					try {
						switch (methodName) {
						case "login":
						case "webLogin":
							userIdInt = userService.getUserIdByPhone((String)map.get("loginName"));
							userId = String.valueOf(userIdInt);
							if(userIdInt.equals("-1")){
								userService.ClearUserInfoFromCache(userIdInt); //清除缓存数据
							}
							break;
						default:
							break;
						}
					} catch (Exception e) {
						logger.error("根据登录账号获取userIdInt时发生异常。", e);
					}
					
					//如果userId已经有了（已经通过web cookie获取到，或者通过登录方法获取到），则不用从map中获取
					if(StringUtils.isBlank(userId)){
						//提前尝试获取userId，以便保存到用户日志中
						String userToken = (String) map.get("userToken");
						if(StringUtils.isNotBlank(userToken)){
							userId = redisService.getUserIdByUsertoken(userToken); // 根据userToken获取userId
						}
					}
					
					//获得userIdInt：
					if(StringUtils.isNotBlank(userId) && userIdInt.equals("-1")){
						//map.put("userid", userId);
						try {
							userIdInt = userId;
							//map.put("userIdInt", userIdInt);
						} catch (Exception e) {
							logger.error("转换userId为int时发生了异常：userId={}", userId, e);
						}
					}
					map.put("userId", userId);
					map.put("userIdInt", userIdInt);

					//提前获取前端类型
					String version = map.get("version")==null?"":map.get("version").toString();
					map.put("version", version);
					
					//提前获取前端设备类型：
					String platform = (String)map.get("platform");//==null?"":map.get("plateform").toString();
					if(StringUtils.isBlank(platform)){
						platform = map.get("plateform")==null?"unknown":map.get("plateform").toString();
						map.put("platform", platform);
					}
					
					if(isLoginRequired(method) && userIdInt.equals("-1")) { // 该接口需要登录却没有登录……
						result = new JsonResultOut(ReturnCode.NOTLOGIN, "用户未登录或已经过期，请重新登录。", null);
					}else if(isTooFrequentRequest(invocation.getMethod(), userId)){ // 如果是太频繁的请求……
						result = new JsonResultOut(ReturnCode.ERROR, "操作太快了，休息几秒再试吧。", null);
					}
					
					if(map.size()>0){
						allParams.add(map);
					}
				}else if(arg instanceof HttpServletRequest){
					
					HttpServletRequest request = (HttpServletRequest) arg;
					
					//通过cookie中的token从redis中获取userId
					String webToken = WebUtils.getCookieByName(request, WebConstants.CookieName.Token);
					if(StringUtils.isNotBlank(webToken)){
						userId = redisService.getUserIdByWebToken(webToken); //根据webToken获取userId
						logger.debug("Got userId via webToken, userId={}", userId);
					}	
					
					//获取请求方的IP地址到log中
					/*String ip = WebUtils.getIpAddress(request);
					userOpLog.setLoginIp(ip);
					
					//获取url到log中：
					userOpLog.setUrl(request.getRequestURL().toString());
					*/
					//获取query string 或 posted form data参数
					Map<String, String[]> paramMap = request.getParameterMap();
					if(paramMap!=null && paramMap.size()>0){
						//Map<String, String[]> copyMap = new HashMap<>();
						//copyMap.putAll(paramMap);
						allParams.add(paramMap);
					}
				} else if(arg instanceof HttpServletResponse){
					//do nothing...
				} else if(arg instanceof BaseInModel){// in model
					BaseInModel baseInModel = (BaseInModel)arg;

					//登录等特殊接口，用其他方法获取userId，如果获取不到则为“-1”
					try {
						switch (methodName) {
							case "login":
								userIdInt = userService.getUserIdByPhone(((LoginInModel)arg).getLoginName());
								userId = String.valueOf(userIdInt);
								break;
							default:
								break;
						}
					} catch (Exception e) {
						logger.error("根据登录账号获取userIdInt时发生异常。", e);
					}


					//如果userId已经有了（已经通过web cookie获取到，或者通过登录方法获取到），则不用从map中获取
					if(StringUtils.isBlank(userId)){
						//提前尝试获取userId，以便保存到用户日志中
						String usertoken = baseInModel.getUserToken();
						if(StringUtils.isNotBlank(usertoken)){
							userId = redisService.getUserIdByUsertoken(usertoken); // 根据UserToken获取userId
						}
					}

					//获得userIdInt：
					if(StringUtils.isNotBlank(userId) && userIdInt.equals("-1")){
						//map.put("userid", userId);
						try {
							userIdInt = userId;
							//map.put("userIdInt", userIdInt);
						} catch (Exception e) {
							logger.error("转换userId为int时发生了异常：userId={}", userId, e);
						}
					}
					baseInModel.setUserId(userIdInt);

					//判断是否需要登陆
					if(isLoginRequired(method) && userIdInt.equals("-1")) { // 该接口需要登录却没有登录……
						result = new JsonResultOut(ReturnCode.NOTLOGIN, "用户未登录或已经过期，请重新登录。", null);
					}else if(isTooFrequentRequest(invocation.getMethod(), userId)){ // 如果是太频繁的请求……
						result = new JsonResultOut(ReturnCode.ERROR, "操作太快了，休息几秒再试吧。", null);
					}

					allParams.add(baseInModel);
				} else if(arg != null){ //其他用对象接收的参数
					allParams.add(arg);
				}
			}
		}
		
		try {
			if(result == null){
				// 一切正常的情况下，继续执行被拦截的方法
				result = invocation.proceed();
			}
		} catch (Exception e) {
			logger.error("Exception caught by Method Interceptor!", e);
			result = new JsonResultOut(ReturnCode.EXCEPTION, e.getMessage(), null);
		}
		
		/*if(result instanceof JsonResultOut){
			userOpLog.setResult((JsonResultOut)result);
		}

		userOpLog.setUserId(userIdInt);
		userOpLog.setAllParams(allParams);
		userOpLog.setCostMs(System.currentTimeMillis() - beginTime);*/

		//log每个用户请求到数据库，异步处理
		//logService.saveUserOpLog(userOpLog, "userOpLog");
		
		return result;
	}
	
	
}