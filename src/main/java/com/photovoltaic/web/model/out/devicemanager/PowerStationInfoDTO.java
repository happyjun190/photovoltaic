package com.photovoltaic.web.model.out.devicemanager;

import com.photovoltaic.model.device.TabPowerStation;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ziye on 2017/5/7.
 */
public class PowerStationInfoDTO {
    @ApiModelProperty(value = "电厂ID", required = true)
    private int powerStationId;//电厂ID
    @ApiModelProperty(value = "地区id", required = true)
    private int areaId;//地区id
    @ApiModelProperty(value = "地区名称", required = true)
    private String areaName;//地区名称
    @ApiModelProperty(value = "电站名称", required = true)
    private String powerStationName;//电站名称
    @ApiModelProperty(value = "电站备注说明", required = true)
    private String remark;//电站备注说明
    @ApiModelProperty(value = "电站拥有者id", required = true)
    private int ownerId;//电站拥有者id
    @ApiModelProperty(value = "电站拥有者姓名", required = true)
    private String ownerName;//电站拥有者姓名

    public PowerStationInfoDTO(){}
    public PowerStationInfoDTO(TabPowerStation tabPowerStation){
        powerStationId = tabPowerStation.getId();
        powerStationName = tabPowerStation.getName();
        areaId = tabPowerStation.getAreaId();
        areaName = tabPowerStation.getAreaName();
        remark = tabPowerStation.getRemark();
        ownerId = tabPowerStation.getOwnerId();
        ownerName = tabPowerStation.getOwnerName();
    }

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
