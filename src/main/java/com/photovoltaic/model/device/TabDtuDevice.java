package com.photovoltaic.model.device;

import java.util.Date;

/**
 * Created by wushenjun on 2017/5/7.
 * dtu设备表
 */
public class TabDtuDevice {
    private int id;
    private int powerStationId;//电厂ID
    private String model;//dtu型号
    private String authKey;//socket校验串
    private int status;//dtu设备状态 0正常 1废弃 其他状态待需求完善
    private int parity;//有无奇偶校验位 0有 1无
    private String seriesRate;//串口速率bps 可以在一个区间,暂时一个字段表示 如:110bps ~ 230400bps
    private Date mtime;//修改时间
    private Date ctime;//创建时间


    private String powerStationName;//电站名称


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }
}
