package com.photovoltaic.web.model.in.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * app用户登录参数
 */
@ApiModel
public class RegistInModel {

    @ApiModelProperty(value = "登录账号", example="admin", required = true)
    String loginName;

    @ApiModelProperty(value = "BASE64之后的密码", example = "Y2NZV0ZoTVRJek5EVTJZbUppWWc9PQ==", required = true)
    String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
