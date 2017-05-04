package com.photovoltaic.web.model.out.user;

import com.photovoltaic.model.user.TabUserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/4 0004.
 */
@ApiModel
public class UserInfoDTO {

    @ApiModelProperty(value = "用户id", required = true)
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


    public UserInfoDTO(){}
    public UserInfoDTO(TabUserInfo tabUserInfo) {
        userId = tabUserInfo.getId();
        userName = tabUserInfo.getLoginName();
        sex = tabUserInfo.getSex();
        code = tabUserInfo.getCode();
        loginName = tabUserInfo.getLoginName();
        chName = tabUserInfo.getChName();
        title = tabUserInfo.getTitle();
        eMail = tabUserInfo.geteMail();
        mobileCode = tabUserInfo.getMobileCode();
        remark = tabUserInfo.getRemark();
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
