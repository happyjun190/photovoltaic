package com.photovoltaic.web.model.in.auth;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/8.
 * 修改密码
 */
@ApiModel
public class UpdateUserPwdInModel extends BaseInModel {
    @ApiModelProperty(value = "旧登录密码,MD5之后的密码", example = "e10adc3949ba59abbe56e057f20f883e", required = true)
    private String oldPwd;

    @ApiModelProperty(value = "新登录密码,BASE64之后的密码", example = "Y2NZV0ZoTVRJek5EVTJZbUppWWc9PQ==", required = true)
    private String newPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
