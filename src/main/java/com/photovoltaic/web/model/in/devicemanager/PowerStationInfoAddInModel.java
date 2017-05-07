package com.photovoltaic.web.model.in.devicemanager;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/7.
 * 电站新增或更新 inModel
 */
@ApiModel
public class PowerStationInfoAddInModel extends BaseInModel {
    @ApiModelProperty(value = "电厂ID(新增时无需此字段(传0即可),编辑时需要)", example = "1", required = true)
    private int powerStationId;//电厂ID
    @ApiModelProperty(value = "地区id", example = "11", required = true)
    private int areaId;//地区id
    @ApiModelProperty(value = "电站名称", example = "泊吾光伏电站1", required = true)
    private String powerStationName;//电站名称
    @ApiModelProperty(value = "电站备注说明", example = "泊吾光伏电站1", required = true)
    private String remark;//电站备注说明
    @ApiModelProperty(value = "电站拥有者id", example = "8", required = true)
    private int ownerId;//电站拥有者id

    public int getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(int powerStationId) {
        this.powerStationId = powerStationId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
