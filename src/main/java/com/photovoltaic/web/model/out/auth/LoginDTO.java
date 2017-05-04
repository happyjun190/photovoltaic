package com.photovoltaic.web.model.out.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 地区DTO
 * Created by XuJijun on 2017/03/02.
 */
@ApiModel
public class LoginDTO {
    @ApiModelProperty(value = "用户id", required = true)
    private int userId;
    @ApiModelProperty(value = "用户token", required = true)
    private String userToken;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}