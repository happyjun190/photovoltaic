package com.photovoltaic.service.commons.impl;

import com.photovoltaic.commons.cache.IRedisOperator;
import com.photovoltaic.commons.constants.RedisConstants;
import com.photovoltaic.dao.user.UserInfoDAO;
import com.photovoltaic.service.commons.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author shenjun
 * @date 2016年09月22日
 */
@Service
public class UserService implements IUserService {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private IRedisOperator redisOperator;
	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public void ClearUserInfoFromCache(String userId){
		redisOperator.delete(RedisConstants.Prefix.USER_INFO.id()+userId);
	}
	
	@Override
	public String getUserIdByPhone(String loginName) {
		//TODO
		String result = userInfoDAO.getUserIdByLoginName(loginName);
		return (result==null)? "-1" : result;
	}
}