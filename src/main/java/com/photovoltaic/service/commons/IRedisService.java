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


	/**
	 * app 根据token从缓存中获取userId
	 * @param webToken
	 * @return
	 */
	String getUserIdByAppToken(String webToken);


	/**
	 * admin 根据token从缓存中获取userId
	 * @param adminToken
	 * @return
	 */
	String getUserIdByAdminToken(String adminToken);

	/**
	 * www 根据token从缓存中获取userId
	 * @param wwwToken
	 * @return
	 */
	String getUserIdByWWWToken(String wwwToken);

}
