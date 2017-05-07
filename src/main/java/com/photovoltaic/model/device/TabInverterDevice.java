package com.photovoltaic.model.device;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by wushenjun on 2017/4/17.
 */
public class TabInverterDevice {
    private int id;
    private String name;//逆变器名称
    private String inverterAddr;//逆变器地址
    private int dtuId;//dtu设备id
    private int status;//dtu设备状态 0正常 1废弃 其他状态待需求完善
    private String inverterType;//逆变器类型 0英威腾逆变器  1长虹逆变器 2.....
    private String version;//版本(特别是针对长虹逆变器不同版本的数据协议)
    private String phaseType;//phase类型: 1单相 2二相 3三相
    private BigDecimal powerSize;//功率大小(单位KW)
    private Date ctime;//创建时间
    private Date mtime;//修改时间
    private String gridStandard;//并网标准
    private String model;//型号
    private String softVersion;//软件版本号
    private String serialNumber;//序列号
    private String manufacturer;//生产厂家

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInverterAddr() {
        return inverterAddr;
    }

    public void setInverterAddr(String inverterAddr) {
        this.inverterAddr = inverterAddr;
    }

    public int getDtuId() {
        return dtuId;
    }

    public void setDtuId(int dtuId) {
        this.dtuId = dtuId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInverterType() {
        return inverterType;
    }

    public void setInverterType(String inverterType) {
        this.inverterType = inverterType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(String phaseType) {
        this.phaseType = phaseType;
    }

    public BigDecimal getPowerSize() {
        return powerSize;
    }

    public void setPowerSize(BigDecimal powerSize) {
        this.powerSize = powerSize;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getGridStandard() {
        return gridStandard;
    }

    public void setGridStandard(String gridStandard) {
        this.gridStandard = gridStandard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
