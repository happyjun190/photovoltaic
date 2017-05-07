package com.photovoltaic.web.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/7.
 * 通过查询model
 */
@ApiModel
public class CommonQueryInModel extends BaseInModel {
    @ApiModelProperty(value = "页码(用于分页)", example="1", required = true)
    private int pageNum;
    @ApiModelProperty(value = "每页多少条数据(用于分页)", example="10", required = true)
    private int pageSize;
    @ApiModelProperty(value = "查询名", example="名字", required = true)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
