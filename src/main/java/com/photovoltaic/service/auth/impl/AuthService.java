package com.photovoltaic.service.auth.impl;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.commons.util.EncryptUtils;
import com.photovoltaic.commons.util.MD5Util;
import com.photovoltaic.commons.util.SecurityUtils;
import com.photovoltaic.dao.user.UserInfoDAO;
import com.photovoltaic.model.user.TabUserInfo;
import com.photovoltaic.service.auth.IAuthService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public JsonResult regist(Map<String, Object> map) {
        String loginName = (String) map.get("loginName");//注册账号
        String password = (String) map.get("password");//登录密码
        if (StringUtils.isBlank(loginName)) {
            return new JsonResult(ReturnCode.PARAMSERROR, "账号不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return new JsonResult(ReturnCode.PARAMSERROR, "密码不能为空！");
        }
        /*if (!loginName.matches(NUMBER)) {
            return new JsonResult(ReturnCode.PARAMSERROR, "手机号码输入错误！");
        }*/

        //对加密的明文密码进行解密
        password = EncryptUtils.getPwdFromBase64(password);

        //根据注册账号判断用户是否已经注册
        TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(loginName);
        if(tabUserInfo!=null) {
            return new JsonResult(ReturnCode.PARAMSERROR, "该账号已被注册!");
        }

        String loginSalt = SecurityUtils.getRandNumber(5); // md5加密盐值
        String userId = this.addUserInfo(loginName, password, loginSalt);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("userId", userId);

        return new JsonResult(ReturnCode.SUCCESS, "注册成功！", resultMap);
    }

    @Override
    public JsonResult appLogin(Map<String, Object> map) {
        return null;
    }

    @Override
    public JsonResult webLogin(Map<String, Object> map) {

        String loginName = (String) map.get("loginName");//注册账号
        String password = (String) map.get("password");//登录密码
        if (StringUtils.isAnyEmpty(loginName,password)) {
            return new JsonResult(ReturnCode.PARAMSERROR, "请输入账号或密码!");
        }
        logger.info("password:{}", EncryptUtils.MD5Str(password));
        //根据注册账号判断用户是否已经注册
        TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(loginName);
        if(tabUserInfo!=null && tabUserInfo.getPassword().equals(EncryptUtils.MD5Str(password + tabUserInfo.getLoginSalt()))) {
            //TODO
            return new JsonResult(ReturnCode.SUCCESS, "登录成功！");
        }

        return new JsonResult(ReturnCode.PARAMSERROR, "账号或密码错误！");
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
