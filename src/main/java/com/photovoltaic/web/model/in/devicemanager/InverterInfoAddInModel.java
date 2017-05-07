package com.photovoltaic.web.model.in.devicemanager;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器新增或更新 inModel
 */
@ApiModel
public class InverterInfoAddInModel extends BaseInModel {
    @ApiModelProperty(value = "逆变器id(新增时无需此字段(传0即可),编辑时需要)", example = "1",required = true)
    private int inverterId;
    @ApiModelProperty(value = "dtu设备id", example = "1",required = true)
    private int dtuId;
    @ApiModelProperty(value = "逆变器地址(配合dtu设备，数据采集需要)", example = "03",required = true)
    private String inverterAddr;
    @ApiModelProperty(value = "逆变器名称", example = "光伏逆变器",required = true)
    private String inverterName;//逆变器名称
    /*@ApiModelProperty(value = "电站名称(针对输出时)", example = "光伏发电站",required = true)
    private String powerStationName;//电站名称*/
    @ApiModelProperty(value = "电站id", example = "1",required = true)
    private int powerStationId;//电站id
    @ApiModelProperty(value = "并网标准", example = "GB20046",required = true)
    private String gridStandard;//并网标准
    @ApiModelProperty(value = "型号", example = "209",required = true)
    private String model;//型号
    @ApiModelProperty(value = "软件版本号", example = "1.2.0",required = true)
    private String softVersion;//软件版本号
    @ApiModelProperty(value = "系列号", example = "1093",required = true)
    private String serialNumber;//序列号
    @ApiModelProperty(value = "生产厂家", example = "英威腾",required = true)
    private String manufacturer;//生产厂家

    public int getInverterId() {
        return inverterId;
    }

    public void setInverterId(int inverterId) {
        this.inverterId = inverterId;
    }

    public String getInverterName() {
        return inverterName;
    }

    public void setInverterName(String inverterName) {
        this.inverterName = inverterName;
    }

    /*public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }*/

    public int getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(int powerStationId) {
        this.powerStationId = powerStationId;
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
}
