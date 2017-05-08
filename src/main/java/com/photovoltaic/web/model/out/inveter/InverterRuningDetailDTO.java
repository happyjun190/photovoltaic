package com.photovoltaic.web.model.out.inveter;

import com.photovoltaic.model.device.TabInverterDevice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by ziye on 2017/5/8.
 * 逆变器设备运行详情DTO
 */
@ApiModel
public class InverterRuningDetailDTO {

    @ApiModelProperty(value = "逆变器id", required = true)
    private int inverterId;//逆变器id
    @ApiModelProperty(value = "逆变器名称", required = true)
    private String inverterName;//逆变器名称
    @ApiModelProperty(value = "逆变器状态", required = true)
    private int status;//逆变器状态
    @ApiModelProperty(value = "额定功率", required = true)
    private BigDecimal powerRating;//额定功率
    @ApiModelProperty(value = "型号", required = true)
    private String model;//型号
    @ApiModelProperty(value = "软件版本号", required = true)
    private String softVersion;//软件版本号
    @ApiModelProperty(value = "序列号", required = true)
    private String serialNumber;//序列号
    @ApiModelProperty(value = "生产厂家", required = true)
    private String manufacturer;//生产厂家
    @ApiModelProperty(value = "并网标准", required = true)
    private String gridStandard;//并网标准
    @ApiModelProperty(value = "所属电站名称", required = true)
    private String powerStationName;//所属电站
    @ApiModelProperty(value = "当前输入功率(KW)", required = true)
    private BigDecimal inputPower;//输入功率(KW)
    @ApiModelProperty(value = "当前输出功率(KW)", required = true)
    private BigDecimal outputPower;//输出功率(KW)
    @ApiModelProperty(value = "历史峰值功率(KW)", required = true)
    private BigDecimal historypeakpower;
    @ApiModelProperty(value = "总发电量/累计发电量", required = true)
    private BigDecimal totalGenerationPower;//总发电量
    @ApiModelProperty(value = "累计CO2减排量", required = true)
    private BigDecimal totalCO2Reduction;//累计CO2减排量
    @ApiModelProperty(value = "累计省钱量", required = true)
    private BigDecimal totalSaveMoney;//累计省钱量
    @ApiModelProperty(value = "pv1电压", required = true)
    private BigDecimal pv1Voltage;//pv1电压
    @ApiModelProperty(value = "pv2电压", required = true)
    private BigDecimal pv2Voltage;//pv2电压
    @ApiModelProperty(value = "pv3电压", required = true)
    private BigDecimal pv3Voltage;//pv3电压
    @ApiModelProperty(value = "pv4电压", required = true)
    private BigDecimal pv4Voltage;//pv4电压
    @ApiModelProperty(value = "pv1电流", required = true)
    private BigDecimal pv1ElectricCurrent;//pv1电流
    @ApiModelProperty(value = "pv2电流", required = true)
    private BigDecimal pv2ElectricCurrent;//pv2电流
    @ApiModelProperty(value = "pv3电流", required = true)
    private BigDecimal pv3ElectricCurrent;//pv3电流
    @ApiModelProperty(value = "pv4电流", required = true)
    private BigDecimal pv4ElectricCurrent;//pv4电流
    @ApiModelProperty(value = "U相电压", required = true)
    private BigDecimal uPhaseVoltage;//U相电压
    @ApiModelProperty(value = "V相电压", required = true)
    private BigDecimal vPhaseVoltage;//V相电压
    @ApiModelProperty(value = "W相电压", required = true)
    private BigDecimal wPhaseVoltage;//W相电压
    @ApiModelProperty(value = "BUS相电压", required = true)
    private BigDecimal busPhaseVoltage;//BUS相电压
    @ApiModelProperty(value = "U相电流", required = true)
    private BigDecimal uPhaseElectricCurrent;//U相电流
    @ApiModelProperty(value = "V相电流", required = true)
    private BigDecimal vPhaseElectricCurrent;//V相电流
    @ApiModelProperty(value = "W相电流", required = true)
    private BigDecimal wPhaseElectricCurrent;//W相电流
    @ApiModelProperty(value = "BUS相电流", required = true)
    private BigDecimal busPhaseElectricCurrent;//BUS相电流

    public InverterRuningDetailDTO(){}
    public InverterRuningDetailDTO(TabInverterDevice tabInverterDevice){
        inverterId = tabInverterDevice.getId();
        inverterName = tabInverterDevice.getName();
        status = tabInverterDevice.getStatus();
        gridStandard = tabInverterDevice.getGridStandard();
        model = tabInverterDevice.getModel();
        softVersion = tabInverterDevice.getSoftVersion();
        serialNumber = tabInverterDevice.getSerialNumber();
        manufacturer = tabInverterDevice.getManufacturer();
    }


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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(BigDecimal powerRating) {
        this.powerRating = powerRating;
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

    public BigDecimal getInputPower() {
        return inputPower;
    }

    public void setInputPower(BigDecimal inputPower) {
        this.inputPower = inputPower;
    }

    public String getGridStandard() {
        return gridStandard;
    }

    public void setGridStandard(String gridStandard) {
        this.gridStandard = gridStandard;
    }

    public BigDecimal getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(BigDecimal outputPower) {
        this.outputPower = outputPower;
    }

    public BigDecimal getHistorypeakpower() {
        return historypeakpower;
    }

    public void setHistorypeakpower(BigDecimal historypeakpower) {
        this.historypeakpower = historypeakpower;
    }

    public BigDecimal getTotalGenerationPower() {
        return totalGenerationPower;
    }

    public void setTotalGenerationPower(BigDecimal totalGenerationPower) {
        this.totalGenerationPower = totalGenerationPower;
    }

    public BigDecimal getTotalCO2Reduction() {
        return totalCO2Reduction;
    }

    public void setTotalCO2Reduction(BigDecimal totalCO2Reduction) {
        this.totalCO2Reduction = totalCO2Reduction;
    }

    public BigDecimal getTotalSaveMoney() {
        return totalSaveMoney;
    }

    public void setTotalSaveMoney(BigDecimal totalSaveMoney) {
        this.totalSaveMoney = totalSaveMoney;
    }

    public BigDecimal getPv1Voltage() {
        return pv1Voltage;
    }

    public void setPv1Voltage(BigDecimal pv1Voltage) {
        this.pv1Voltage = pv1Voltage;
    }

    public BigDecimal getPv2Voltage() {
        return pv2Voltage;
    }

    public void setPv2Voltage(BigDecimal pv2Voltage) {
        this.pv2Voltage = pv2Voltage;
    }

    public BigDecimal getPv3Voltage() {
        return pv3Voltage;
    }

    public void setPv3Voltage(BigDecimal pv3Voltage) {
        this.pv3Voltage = pv3Voltage;
    }

    public BigDecimal getPv4Voltage() {
        return pv4Voltage;
    }

    public void setPv4Voltage(BigDecimal pv4Voltage) {
        this.pv4Voltage = pv4Voltage;
    }

    public BigDecimal getPv1ElectricCurrent() {
        return pv1ElectricCurrent;
    }

    public void setPv1ElectricCurrent(BigDecimal pv1ElectricCurrent) {
        this.pv1ElectricCurrent = pv1ElectricCurrent;
    }

    public BigDecimal getPv2ElectricCurrent() {
        return pv2ElectricCurrent;
    }

    public void setPv2ElectricCurrent(BigDecimal pv2ElectricCurrent) {
        this.pv2ElectricCurrent = pv2ElectricCurrent;
    }

    public BigDecimal getPv3ElectricCurrent() {
        return pv3ElectricCurrent;
    }

    public void setPv3ElectricCurrent(BigDecimal pv3ElectricCurrent) {
        this.pv3ElectricCurrent = pv3ElectricCurrent;
    }

    public BigDecimal getPv4ElectricCurrent() {
        return pv4ElectricCurrent;
    }

    public void setPv4ElectricCurrent(BigDecimal pv4ElectricCurrent) {
        this.pv4ElectricCurrent = pv4ElectricCurrent;
    }

    public BigDecimal getuPhaseVoltage() {
        return uPhaseVoltage;
    }

    public void setuPhaseVoltage(BigDecimal uPhaseVoltage) {
        this.uPhaseVoltage = uPhaseVoltage;
    }

    public BigDecimal getvPhaseVoltage() {
        return vPhaseVoltage;
    }

    public void setvPhaseVoltage(BigDecimal vPhaseVoltage) {
        this.vPhaseVoltage = vPhaseVoltage;
    }

    public BigDecimal getwPhaseVoltage() {
        return wPhaseVoltage;
    }

    public void setwPhaseVoltage(BigDecimal wPhaseVoltage) {
        this.wPhaseVoltage = wPhaseVoltage;
    }

    public BigDecimal getBusPhaseVoltage() {
        return busPhaseVoltage;
    }

    public void setBusPhaseVoltage(BigDecimal busPhaseVoltage) {
        this.busPhaseVoltage = busPhaseVoltage;
    }

    public BigDecimal getuPhaseElectricCurrent() {
        return uPhaseElectricCurrent;
    }

    public void setuPhaseElectricCurrent(BigDecimal uPhaseElectricCurrent) {
        this.uPhaseElectricCurrent = uPhaseElectricCurrent;
    }

    public BigDecimal getvPhaseElectricCurrent() {
        return vPhaseElectricCurrent;
    }

    public void setvPhaseElectricCurrent(BigDecimal vPhaseElectricCurrent) {
        this.vPhaseElectricCurrent = vPhaseElectricCurrent;
    }

    public BigDecimal getwPhaseElectricCurrent() {
        return wPhaseElectricCurrent;
    }

    public void setwPhaseElectricCurrent(BigDecimal wPhaseElectricCurrent) {
        this.wPhaseElectricCurrent = wPhaseElectricCurrent;
    }

    public BigDecimal getBusPhaseElectricCurrent() {
        return busPhaseElectricCurrent;
    }

    public void setBusPhaseElectricCurrent(BigDecimal busPhaseElectricCurrent) {
        this.busPhaseElectricCurrent = busPhaseElectricCurrent;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }
}
