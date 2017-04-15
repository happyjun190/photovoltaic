package com.photovoltaic.service.auth;

import com.photovoltaic.commons.json.JsonResult;

import java.util.Map;

/**
 * Created by wushenjun on 2017/4/15.
 * 权限验证interface，登录注册等
 */
public interface IAuthService {

    /**
     * 用户注册
     * @param map
     * @return
     */
    JsonResult regist(Map<String, Object> map);


    /**
     * app用户登录
     * @param map
     * @return
     */
    JsonResult appLogin(Map<String, Object> map);


    /**
     * web用户登录
     * @param map
     * @return
     */
    JsonResult webLogin(Map<String, Object> map);
}
