package com.photovoltaic.web.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ziye on 2017/5/7.
 * 通过id获取相应数据信息inModel
 */
@ApiModel
public class CommonSelectOneInModel extends BaseInModel {
    @ApiModelProperty(value = "相应数据id", example = "2",required = true)
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
