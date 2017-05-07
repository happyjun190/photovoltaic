package com.photovoltaic.service.user;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.user.UserInfoAddInModel;
import com.photovoltaic.web.model.in.user.UserInfoQueryInModel;
import com.photovoltaic.web.model.out.user.UserInfoDTO;

import java.util.List;

/**
 * Created by wushenjun on 2017/5/4 0004.
 * 用户管理interface
 */
public interface IUserManagerService {

    /**
     * 通过各种查询条件，查询用户列表
     * @param inModel
     * @return
     */
    JsonResultOut<List<UserInfoDTO>> getUserInfoList(UserInfoQueryInModel inModel);


    /**
     * 新增或更新用户信息
     * @param inModel
     * @return
     */
    JsonResultOut insertOrUpdateUserInfo(UserInfoAddInModel inModel);

}
