package com.photovoltaic.service.user.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.util.EncryptUtils;
import com.photovoltaic.commons.util.SecurityUtils;
import com.photovoltaic.dao.user.UserInfoDAO;
import com.photovoltaic.model.user.TabUserInfo;
import com.photovoltaic.service.user.IUserManagerService;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.user.UserInfoAddInModel;
import com.photovoltaic.web.model.in.user.UserInfoQueryInModel;
import com.photovoltaic.web.model.out.user.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/4 0004.
 * 用户管理service
 */
@Service
public class UserManagerService implements IUserManagerService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public JsonResultOut<List<UserInfoDTO>> getUserInfoList(UserInfoQueryInModel inModel) {
        Map<String, Object> queryParamsMap = new HashMap<>();
        int pageStart = (inModel.getPageNum()-1)*inModel.getPageNum();
        List<TabUserInfo> userInfoList = userInfoDAO.getUserInfoList(pageStart, inModel.getPageSize(), queryParamsMap);

        //组装用户信息数据
        List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
        //使用java8新特性
        userInfoList.forEach(tabUserInfo -> userInfoDTOList.add(new UserInfoDTO(tabUserInfo)));

        return new JsonResultOut(ReturnCode.SUCCESS, "获取用户列表成功!", userInfoDTOList);
    }


    @Override
    public JsonResultOut insertOrUpdateUserInfo(UserInfoAddInModel inModel) {

        //新增用户
        if(inModel.getId()==0) {

            //根据注册账号判断用户是否已经注册
            TabUserInfo tabUserInfo = userInfoDAO.getUserInfoByLoginName(inModel.getLoginName());
            if(tabUserInfo!=null) {
                return  new JsonResultOut(ReturnCode.PARAMSERROR, "该账号已被注册!");
            }

            String loginSalt = SecurityUtils.getRandNumber(5); // md5加密盐值
            //对加密的明文密码进行解密
            String password = EncryptUtils.getPwdFromBase64(inModel.getPassword());
            password = EncryptUtils.encryptPassword(password, loginSalt);
            inModel.setPassword(password);
            inModel.setLoginSalt(loginSalt);
            userInfoDAO.adminAddUserInfo(inModel);
        } else {//编辑用户(不修改密码)
            userInfoDAO.adminUpdateUserInfo(inModel);
        }

        return  new JsonResultOut(ReturnCode.SUCCESS, "新增/更新用户信息成功!");
    }
}
