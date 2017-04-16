package com.photovoltaic.service.commons;

public interface IRedisService {
	/**
	 * 根据usertoken从缓存中获取userid
	 * @param usertoken
	 * @return userid,空返回null
	 */
	String getUserIdByUsertoken(String usertoken);

	/**
	 * web 根据token从缓存中获取userId
	 * @param webToken
	 * @return
	 */
	String getUserIdByWebToken(String webToken);
}
