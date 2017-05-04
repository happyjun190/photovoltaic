package com.photovoltaic.service.user.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.dao.user.UserInfoDAO;
import com.photovoltaic.model.user.TabUserInfo;
import com.photovoltaic.service.user.IUserManagerService;
import com.photovoltaic.web.model.JsonResultOut;
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
}
