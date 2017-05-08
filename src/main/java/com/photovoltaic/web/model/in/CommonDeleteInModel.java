package com.photovoltaic.web.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/8.
 * 通用删除 inModel
 */
@ApiModel
public class CommonDeleteInModel extends BaseInModel {
    @ApiModelProperty(value = "相应数据id", example = "1000",required = true)
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
