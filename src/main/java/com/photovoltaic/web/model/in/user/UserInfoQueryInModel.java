package com.photovoltaic.web.model.in.user;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/4 0004.
 * 查询用户列表model
 */
@ApiModel
public class UserInfoQueryInModel extends BaseInModel {
    @ApiModelProperty(value = "页码(用于分页)", example="1", required = true)
    private int pageNum;
    @ApiModelProperty(value = "每页多少条数据(用于分页)", example="10", required = true)
    private int pageSize;
    @ApiModelProperty(value = "用户姓名", example = "Mr.Wong", required = true)
    private String userName;
    @ApiModelProperty(value = "用户中文名", example = "王总", required = true)
    private String chName;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }
}
