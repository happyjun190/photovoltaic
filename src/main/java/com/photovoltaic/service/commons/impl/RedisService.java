package com.photovoltaic.service.commons.impl;

import com.photovoltaic.commons.cache.IRedisOperator;
import com.photovoltaic.commons.constants.RedisConstants;
import com.photovoltaic.service.commons.IRedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements IRedisService {
	private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

	@Autowired
	private IRedisOperator redisOperator;
	
	/**
	 * 根据Web token获取userId
	 */
	@Override
	public String getUserIdByWebToken(String webToken) {
		String userId = null;
		if(StringUtils.isNotBlank(webToken)){
			String key = RedisConstants.Prefix.WEB_TOKEN + webToken;
			//userId = redisOperator.get(key);
			try {
				userId = redisOperator.get(key);
			} catch (Exception e) {
				redisOperator.delete(key);
				logger.warn("清除旧版本的key：{}",key);
			}


			if(StringUtils.isNotBlank(userId)){
				logger.debug("获取userid成功,userid为{}", userId);
			}else{
				userId = "";
				logger.info("获取userid为空，webToken：{}", webToken);
			}
		}else{
			logger.info("Web token为空,无法获取userId...");
		}
		return userId;
	}


	@Override
	public String getUserIdByAppToken(String appToken) {
		String userid = null;
		if(StringUtils.isNotBlank(appToken)){
			String temp = RedisConstants.Prefix.APP_TOKEN + appToken;
			logger.debug("开始获取key为{}的userid...", temp);
			userid = redisOperator.get(temp);
			if(userid!=null){
				logger.debug("获取app端userid成功,userid为{}", userid);
			}else{
				userid = "";
				logger.info("获取app端userid为空，usertoken：{}", appToken);
			}
		}else{
			logger.info("app端usertoken为空,无法获取userid...");
		}
		return userid;
	}

	public String getUserIdByUsertoken(String usertoken) {
		String userid = null;
		if(StringUtils.isNotBlank(usertoken)){
			String temp = RedisConstants.Prefix.APP_TOKEN + usertoken;
			logger.debug("开始获取key为{}的userid...", temp);
			userid = redisOperator.get(temp);
			if(userid!=null){
				logger.debug("获取userid成功,userid为{}", userid);
			}else{
				userid = "";
				logger.info("获取userid为空，usertoken：{}", usertoken);
			}
		}else{
			logger.info("usertoken为空,无法获取userid...");
		}
		return userid;
	}


	@Override
	public String getUserIdByAdminToken(String adminToken) {
		String userid = null;
		if(StringUtils.isNotBlank(adminToken)){
			String temp = RedisConstants.Prefix.ADMIN_TOKEN + adminToken;
			logger.debug("开始获取key为{}的userid...", temp);
			userid = redisOperator.get(temp);
			if(userid!=null){
				logger.debug("获取admin端userid成功,userid为{}", userid);
			}else{
				userid = "";
				logger.info("获取admin端userid为空，usertoken：{}", adminToken);
			}
		}else{
			logger.info("admin端usertoken为空,无法获取userid...");
		}
		return userid;
	}

	@Override
	public String getUserIdByWWWToken(String wwwToken) {
		String userid = null;
		if(StringUtils.isNotBlank(wwwToken)){
			String temp = RedisConstants.Prefix.WWW_TOKEN + wwwToken;
			logger.debug("开始获取key为{}的userid...", temp);
			userid = redisOperator.get(temp);
			if(userid!=null){
				logger.debug("获取www端userid成功,userid为{}", userid);
			}else{
				userid = "";
				logger.info("获取www端userid为空，usertoken：{}", wwwToken);
			}
		}else{
			logger.info("www端usertoken为空,无法获取userid...");
		}
		return userid;
	}
}
