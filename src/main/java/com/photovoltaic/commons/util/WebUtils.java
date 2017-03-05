package com.photovoltaic.commons.util;

import com.photovoltaic.commons.constants.WebConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class WebUtils {
	//private final static Logger logger = LoggerFactory.getLogger(WebUtils.class);
	
	static char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	/**
	 * 获得请求的IP地址
	 * 
	 * @param request
	 * @return IP地址
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");

		if (ip!=null && ip.length()!=0) {
			//如果有多次代理（如"1.1.1.1, 2.2.2.2, 3.3.3.3"），只取第一个：
			if(ip!=null && ip.contains(",")){
				ip=ip.substring(0, ip.indexOf(","));
			}
		}
		if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip; 
	}
	
	/**
	 * 获取HttpRequest中的所有Headers
	 * @author shenjun
	 * @param HttpServletRequest
	 * @return
	 */
	public static Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}

		return map;
	}
	
	/**
	 * 设置cookie到response中
	 * @param response
	 * @param name：  cookie名字
	 * @param value： cookie值
	 * @param maxAge： cookie生命周期， 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
	    Cookie cookie = new Cookie(name, value);
	    cookie.setPath("/");
	    if(maxAge>0){
	    	cookie.setMaxAge(maxAge);
	    }
	    response.addCookie(cookie);
	}
	
	/**
	 * 设置cookie到response中
	 * @param response
	 * @param name：  cookie名字
	 * @param value： cookie值
	 * @param maxAge： cookie生命周期， 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, WebConstants.CookieName name, String value, int maxAge){
		addCookie(response, name.name(), value, maxAge);
	}
	
	/**
	 * 根据名字从request中获取cookie的值
	 * @param request
	 * @param name： cookie名字
	 * @return
	 */
	public static String getCookieByName(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();//获取cookie数组
		if(cookies != null){
			for(Cookie cookie : cookies){
			    if(cookie.getName().equals(name)){
			    	return cookie.getValue();
			    }
			}
		}
		return null;
	}
	
	/**
	 * 根据名字从request中获取cookie的值
	 * @param request
	 * @param name： cookie名字
	 * @return
	 */
	public static String getCookieByName(HttpServletRequest request, WebConstants.CookieName name){
		return getCookieByName(request, name.name());
	}
	
	/**
	 * 生成一个位数为count的随机验证码
	 * @param count
	 * @return
	 */
	public static String genCaptcha(int count) {
		StringBuilder captcha = new StringBuilder();
		
		for(int i=0; i<count; i++){
			char c = chars[ThreadLocalRandom.current().nextInt(chars.length)];//随机选取一个字母或数字
			captcha.append(c);
		}
		return captcha.toString();
	}
	
	/**
	 * 为一个验证码生成一个图片
	 * 
	 * 特性：
	 * - 颜色随机
	 * - 上下位置随机
	 * - 左右位置随机，但字符之间不会重叠
	 * - 左右随机旋转一个角度
	 * - 避免字符出界
	 * - 随机颜色的小字符做背景干扰
	 * - 根据字符大小自动调整图片大小、自动计算干扰字符的个数
	 * 
	 * @author shenjun
	 *  
	 * @param captcha
	 * @return
	 */
	public static BufferedImage genCaptchaImg(String captcha){
		ThreadLocalRandom r = ThreadLocalRandom.current();

		int count = captcha.length();
		int fontSize = 80; //code的字体大小
		int fontMargin = fontSize/4; //字符间隔
		int width = (fontSize+fontMargin)*count+fontMargin; //图片长度
		int height = (int) (fontSize*1.2); //图片高度，根据字体大小自动调整；调整这个系数可以调整字体占图片的比例
		int avgWidth = width/count;	//字符平均占位宽度
		int maxDegree = 26;	//最大旋转度数
		
		//背景颜色
		Color bkColor = Color.WHITE;
		//验证码的颜色
		//Color[] catchaColor = {Color.MAGENTA, Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.PINK};
		Color[] catchaColor = {Color.MAGENTA, Color.BLACK, Color.BLUE};
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		
		//填充底色为灰白
		g.setColor(bkColor);
		g.fillRect(0, 0, width, height);
		
		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		
		//画干扰字母、数字
		int dSize = fontSize/3; //调整分母大小以调整干扰字符大小
		Font font = new Font("Fixedsys", Font.PLAIN, dSize);
		g.setFont(font);
		int dNumber = width*height/dSize/dSize;//根据面积计算干扰字母的个数
		for(int i=0; i<dNumber; i++){
			char d_code = chars[r.nextInt(chars.length)];
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawString(String.valueOf(d_code), r.nextInt(width), r.nextInt(height));
		}
		
		//开始画验证码：
		
		// 创建字体   
		font = new Font(Font.MONOSPACED, Font.ITALIC|Font.BOLD, fontSize);
		// 设置字体     
		g.setFont(font);

		for(int i=0; i<count; i++){
			char c = captcha.charAt(i);
			g.setColor(catchaColor[r.nextInt(catchaColor.length)]);//随机选取一种颜色
			
			//随机旋转一个角度[-maxDegre, maxDegree]
			int degree = r.nextInt(-maxDegree, maxDegree+1);
			
			//偏移系数，和旋转角度成反比，以避免字符在图片中越出边框
			double offsetFactor = 1-(Math.abs(degree)/(maxDegree+1.0));//加上1，避免出现结果为0
			
			g.rotate(degree * Math.PI / 180); //旋转一个角度
			int x = (int) (fontMargin + r.nextInt(avgWidth-fontSize)*offsetFactor); //横向偏移的距离
			int y = (int) (fontSize + r.nextInt(height-fontSize)*offsetFactor); //上下偏移的距离
			
			g.drawString(String.valueOf(c), x, y); //x,y是字符的左下角，偏离原点的距离！！！
			
			g.rotate(-degree * Math.PI / 180); //画完一个字符之后，旋转回原来的角度
			g.translate(avgWidth, 0);//移动到下一个画画的原点
			//System.out.println(c+": x="+x+" y="+y+" degree="+degree+" offset="+offsetFactor);
			
			//X、Y坐标在合适的范围内随机，不旋转：
			//g.drawString(String.valueOf(c), width/count*i+r.nextInt(width/count-fontSize), fontSize+r.nextInt(height-fontSize));
		}
		
		g.dispose();
		
		return image;
	}
	
	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map getParameterMap(HttpServletRequest request) {
	    // 参数Map
	    Map properties = request.getParameterMap();
	    // 返回值Map
	    Map returnMap = new HashMap();
	    Iterator entries = properties.entrySet().iterator();
	    Map.Entry entry;
	    String name = "";
	    String value = "";
	    while (entries.hasNext()) {
	        entry = (Map.Entry) entries.next();
	        name = (String) entry.getKey();
	        Object valueObj = entry.getValue();
	        if(null == valueObj){
	            value = "";
	        }else if(valueObj instanceof String[]){
	            String[] values = (String[])valueObj;
	            for(int i=0;i<values.length;i++){
	                value = values[i] + ",";
	            }
	            value = value.substring(0, value.length()-1);
	        }else{
	            value = valueObj.toString();
	        }
	        returnMap.put(name, value);
	    }
	    return returnMap;
	}
}
