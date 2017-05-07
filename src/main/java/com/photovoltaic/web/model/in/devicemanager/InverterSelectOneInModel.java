package com.photovoltaic.web.model.in.devicemanager;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ziye on 2017/5/7.
 * 获取逆变器信息 inModel
 */
@ApiModel
public class InverterSelectOneInModel extends BaseInModel{
    @ApiModelProperty(value = "逆变器id", example = "2",required = true)
    private int inverterId;

    public int getInverterId() {
        return inverterId;
    }

    public void setInverterId(int inverterId) {
        this.inverterId = inverterId;
    }
}
