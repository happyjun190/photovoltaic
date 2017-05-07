package com.photovoltaic.web.model.out.devicemanager;

import com.photovoltaic.model.device.TabDtuDevice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ziye on 2017/5/7.
 * dtu设备信息
 */
@ApiModel
public class DtuDeviceInfoDTO {
    @ApiModelProperty(value = "dtu id", required = true)
    private int dtuId;
    @ApiModelProperty(value = "电厂ID", required = true)
    private int powerStationId;//电厂ID
    @ApiModelProperty(value = "电厂名称", required = true)
    private String powerStationName;//电厂名称
    @ApiModelProperty(value = "dtu型号", required = true)
    private String model;//dtu型号
    @ApiModelProperty(value = "socket校验串", required = true)
    private String authKey;//socket校验串
    @ApiModelProperty(value = "dtu设备状态(默认为0) 0正常 1废弃 其他状态待需求完善", required = true)
    private int status;//dtu设备状态 0正常 1废弃 其他状态待需求完善
    @ApiModelProperty(value = "有无奇偶校验位 0有 1无", required = false)
    private int parity;//有无奇偶校验位 0有 1无
    @ApiModelProperty(value = "电厂ID", required = false)
    private String seriesRate;//串口速率bps 可以在一个区间,暂时一个字段表示 如:110bps ~ 230400bps

    public DtuDeviceInfoDTO(){}
    public DtuDeviceInfoDTO(TabDtuDevice tabDtuDevice){
        dtuId = tabDtuDevice.getId();
        powerStationId = tabDtuDevice.getPowerStationId();
        powerStationName = tabDtuDevice.getPowerStationName();
        model = tabDtuDevice.getModel();
        authKey = tabDtuDevice.getAuthKey();
        status = tabDtuDevice.getStatus();
        parity = tabDtuDevice.getParity();
        seriesRate = tabDtuDevice.getSeriesRate();
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getParity() {
        return parity;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public String getSeriesRate() {
        return seriesRate;
    }

    public void setSeriesRate(String seriesRate) {
        this.seriesRate = seriesRate;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }
}
