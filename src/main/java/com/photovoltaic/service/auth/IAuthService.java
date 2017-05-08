package com.photovoltaic.service.auth;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.auth.LoginInModel;
import com.photovoltaic.web.model.in.auth.RegistInModel;
import com.photovoltaic.web.model.in.auth.UpdateUserPwdInModel;

/**
 * Created by wushenjun on 2017/4/15.
 * 权限验证interface，登录注册等
 */
public interface IAuthService {

    /**
     * 用户注册
     * @param inModel
     * @return
     */
    JsonResultOut regist(RegistInModel inModel);


    /**
     * app用户登录
     * @param inModel
     * @return
     */
    JsonResultOut appLogin(LoginInModel inModel);


    /**
     * web用户登录
     * @param inModel
     * @return
     */
    JsonResultOut webLogin(LoginInModel inModel);


    /**
     * admin用户登录
     * @param inModel
     * @return
     */
    JsonResultOut adminLogin(LoginInModel inModel);


    /**
     * www用户登录
     * @param inModel
     * @return
     */
    JsonResultOut wwwLogin(LoginInModel inModel);


    /**
     * 修改密码
     * @param inModel
     * @return
     */
    JsonResultOut updateUserLoginPwd(UpdateUserPwdInModel inModel);

}
