package com.photovoltaic.service.auth.impl;

import com.photovoltaic.commons.cache.IRedisOperator;
import com.photovoltaic.commons.constants.RedisConstants;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.commons.util.DateUtils;
import com.photovoltaic.commons.util.EncryptUtils;
import com.photovoltaic.commons.util.SecurityUtils;
import com.photovoltaic.dao.user.UserInfoDAO;
import com.photovoltaic.model.user.TabUserInfo;
import com.photovoltaic.service.auth.IAuthService;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.auth.LoginInModel;
import com.photovoltaic.web.model.in.auth.RegistInModel;
import com.photovoltaic.web.model.out.auth.LoginDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wushenjun on 2017/4/15.
 * 权限验证service，登录注册等
 */
@Service
public class AuthService implements IAuthService {
    /** 数字 */
    public static final String NUMBER = "^[0-9]*$";
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private IRedisOperator redisOperator;

    @Transactional
    @Override
    public JsonResultOut regist(RegistInModel inModel) {
        String loginName = inModel.getLoginName();//注册账号
        String password = inModel.getPassword();//登录密码
        if (StringUtils.isBlank(loginName)) {
            return new JsonResultOut(ReturnCode.PARAMSERROR, "账号不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return new JsonResultOut(ReturnCode.PARAMSERROR, "密码不能为空！");
        }
        /*if (!loginName.matches(NUMBER)) {
            return new JsonResult(ReturnCode.PARAMSERROR, "手机号码输入错误！");
        }*/

        //对加密的明文密码进行解密
        password = EncryptUtils.getPwdFromBase64(password);

        //根据注册账号判断用户是否已经注册
        TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(loginName);
        if(tabUserInfo!=null) {
            return new JsonResultOut(ReturnCode.PARAMSERROR, "该账号已被注册!");
        }

        String loginSalt = SecurityUtils.getRandNumber(5); // md5加密盐值
        String userId = this.addUserInfo(loginName, password, loginSalt);

        /*Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userId", userId);*/

        LoginDTO loginDTO = new LoginDTO();
        //loginDTO.setUserToken(token);
        loginDTO.setUserId(userId);

        return new JsonResultOut(ReturnCode.SUCCESS, "注册成功！", loginDTO);
    }

    @Override
    public JsonResultOut appLogin(LoginInModel inModel) {
        String loginName = inModel.getLoginName();//登录账号
        String password = inModel.getPassword();//登录密码
        if (StringUtils.isAnyEmpty(loginName,password)) {
            return new JsonResultOut(ReturnCode.PARAMSERROR, "请输入账号或密码!");
        }
        logger.info("password:{}", EncryptUtils.MD5Str(password));
        //根据注册账号判断用户是否已经注册
        TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(loginName);
        if(tabUserInfo!=null && tabUserInfo.getPassword().equals(EncryptUtils.MD5Str(password + tabUserInfo.getLoginSalt()))) {
            // 生成一个随机的token
            String token = UUID.randomUUID().toString().replace("-", "");
            String tokenKey = RedisConstants.Prefix.APP_TOKEN + token;
            //TODO
            //保存login相关的信息到redis中
            String userLoginInfoKey = RedisConstants.Prefix.USER_LOGIN_INFO + tabUserInfo.getId();

            Map<String, String> userLoginInfo = new HashMap<>();
            userLoginInfo.put(RedisConstants.UserLoginInfo.APP_TOKEN.id(), token);
            userLoginInfo.put(RedisConstants.UserLoginInfo.APP_LOGIN_TIME.id(), DateUtils.getNowTime());

            redisOperator.hmset(userLoginInfoKey, userLoginInfo);

            int maxRedisAge = RedisConstants.Prefix.APP_TOKEN.ttl();// token存进redis，保存一天（单位：分钟）
            //设置token to userId
            redisOperator.set(tokenKey, tabUserInfo.getId(), maxRedisAge);

            /*Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("userToken", token);*/
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUserToken(token);
            loginDTO.setUserId(tabUserInfo.getId());

            return new JsonResultOut(ReturnCode.SUCCESS, "登录成功！", loginDTO);
        }

        return new JsonResultOut(ReturnCode.PARAMSERROR, "账号或密码错误！");
    }

    @Override
    public JsonResultOut webLogin(LoginInModel inModel) {
        String loginName = inModel.getLoginName();//登录账号
        String password = inModel.getPassword();//登录密码
        if (StringUtils.isAnyEmpty(loginName,password)) {
            return new JsonResultOut(ReturnCode.PARAMSERROR, "请输入账号或密码!");
        }
        logger.info("password:{}", EncryptUtils.MD5Str(password));
        //根据注册账号判断用户是否已经注册
        TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(loginName);
        if(tabUserInfo!=null && tabUserInfo.getPassword().equals(EncryptUtils.MD5Str(password + tabUserInfo.getLoginSalt()))) {
            // 生成一个随机的token
            String token = UUID.randomUUID().toString().replace("-", "");
            String tokenKey = RedisConstants.Prefix.WEB_TOKEN + token;
            //TODO
            //保存login相关的信息到redis中
            String userLoginInfoKey = RedisConstants.Prefix.USER_LOGIN_INFO + tabUserInfo.getId();

            Map<String, String> userLoginInfo = new HashMap<>();
            userLoginInfo.put(RedisConstants.UserLoginInfo.WEB_TOKEN.id(), token);
            userLoginInfo.put(RedisConstants.UserLoginInfo.WEB_LOGIN_TIME.id(), DateUtils.getNowTime());

            redisOperator.hmset(userLoginInfoKey, userLoginInfo);

            int maxRedisAge = RedisConstants.Prefix.WEB_TOKEN.ttl();// token存进redis，保存一天（单位：分钟）
            //设置token to userId
            redisOperator.set(tokenKey, tabUserInfo.getId(), maxRedisAge);

            /*Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("userToken", token);*/

            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setUserToken(token);
            loginDTO.setUserId(tabUserInfo.getId());

            return new JsonResultOut(ReturnCode.SUCCESS, "登录成功！", loginDTO);
        }

        return new JsonResultOut(ReturnCode.PARAMSERROR, "账号或密码错误！");
    }


    /**
     * 用户添加操作
     * @param loginName
     * @param password
     * @param loginSalt
     * @return
     */
    private String addUserInfo(String loginName, String password, String loginSalt) {
        TabUserInfo tabUserInfo = new TabUserInfo();
        password = EncryptUtils.encryptPassword(password, loginSalt);
        tabUserInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        tabUserInfo.setPassword(password);
        tabUserInfo.setLoginSalt(loginSalt);
        tabUserInfo.setLoginName(loginName);
        userInfoDAO.addUserInfo(tabUserInfo);
        return tabUserInfo.getId();
    }
}
