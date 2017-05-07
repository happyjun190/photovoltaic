package com.photovoltaic.web.model.in.devicemanager;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器新增或更新 inModel
 */
@ApiModel
public class DtuDeviceInfoAddInModel extends BaseInModel {
    @ApiModelProperty(value = "dtu id", example = "5", required = true)
    private int dtuId;
    @ApiModelProperty(value = "电厂ID", example = "1", required = true)
    private int powerStationId;//电厂ID
    @ApiModelProperty(value = "dtu型号", example = "model1", required = true)
    private String model;//dtu型号
    @ApiModelProperty(value = "socket校验串", example = "AAABBBCCC", required = true)
    private String authKey;//socket校验串

    public int getDtuId() {
        return dtuId;
    }

    public void setDtuId(int dtuId) {
        this.dtuId = dtuId;
    }

    public int getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(int powerStationId) {
        this.powerStationId = powerStationId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
