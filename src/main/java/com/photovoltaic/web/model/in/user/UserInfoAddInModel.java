package com.photovoltaic.web.model.in.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/4 0004.
 */
@ApiModel
public class UserInfoAddInModel {
    @ApiModelProperty(value = "用户id(新增时无需此字段,编辑时需要)", example = "1",required = true)
    private int userId;
    @ApiModelProperty(value = "用户姓名", required = true)
    private String userName;
    @ApiModelProperty(value = "用户性别 0未设置 1男 2女", required = true)
    private int sex;//用户性别 0未设置 1男 2女
    @ApiModelProperty(value = "用户编号", required = true)
    private String code;
    @ApiModelProperty(value = "用户登录名称", required = true)
    private String loginName;
    @ApiModelProperty(value = "用户中文名", required = true)
    private String chName;
    @ApiModelProperty(value = "用户职称", required = true)
    private String title;
    @ApiModelProperty(value = "邮箱地址", required = true)
    private String eMail;
    @ApiModelProperty(value = "移动电话", required = true)
    private String mobileCode;
    @ApiModelProperty(value = "备注", required = true)
    private String remark;
}
