package com.photovoltaic.service.commons;

/**
 * 
 * @author wushenjun
 * @date 2016年4月15日
 */
public interface IUserService {
	
	/**
	 * 清除redis中的UserInfo信息
	 * @param userId
	 */
	void ClearUserInfoFromCache(String userId);
	
	/**
	 * 根据登录账号获取userId
	 * @param loginName
	 * @return
	 */
	String getUserIdByPhone(String loginName);


	
}