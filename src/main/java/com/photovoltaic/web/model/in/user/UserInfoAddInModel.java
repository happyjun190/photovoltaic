package com.photovoltaic.web.model.in.user;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/4 0004.
 */
@ApiModel
public class UserInfoAddInModel extends BaseInModel {
    @ApiModelProperty(value = "用户id(新增时无需此字段(传0即可),编辑时需要)", example = "1",required = true)
    private int id;
    /*@ApiModelProperty(value = "用户姓名", example = "Mr.chen", required = true)
    private String userName;*/
    @ApiModelProperty(value = "用户性别 0未设置 1男 2女", example = "1", required = true)
    private int sex;//用户性别 0未设置 1男 2女
    @ApiModelProperty(value = "用户编号", example = "000A01", required = true)
    private String code;
    @ApiModelProperty(value = "用户登录名称(不可编辑)", example = "adminLoginName", required = true)
    private String loginName;
    @ApiModelProperty(value = "用户登录密码(BASE64之后的密码)", example = "Y2NZV0ZoTVRJek5EVTJZbUppWWc9PQ==", required = true)
    private String password;
    @ApiModelProperty(value = "用户中文名", example = "陈总", required = true)
    private String chName;
    @ApiModelProperty(value = "用户职称", example = "小陈", required = true)
    private String title;
    @ApiModelProperty(value = "邮箱地址", example = "123456789@qq.com", required = true)
    private String eMail;
    @ApiModelProperty(value = "移动电话", example = "18566666666", required = true)
    private String mobileCode;
    @ApiModelProperty(value = "备注", example = "18566666666", required = true)
    private String remark;
    @ApiModelProperty(value = "登录密码盐值", example = "12345", hidden = true)
    private String loginSalt;

    public int id() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    /*public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }*/

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginSalt() {
        return loginSalt;
    }

    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
