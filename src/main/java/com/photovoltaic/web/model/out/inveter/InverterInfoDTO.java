package com.photovoltaic.web.model.out.inveter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by wushenjun on 2017/4/17.
 * 逆变器综合信息DTO
 */
@ApiModel
public class InverterInfoDTO {
    @ApiModelProperty(value = "逆变器id", required = true)
    private int inverterId;//逆变器id
    @ApiModelProperty(value = "逆变器名称", required = true)
    private String inverterName;//逆变器名称
    @ApiModelProperty(value = "逆变器状态", required = true)
    private int status;//逆变器状态
    @ApiModelProperty(value = "装机容量", required = true)
    private BigDecimal installedCapacity;//装机容量
    @ApiModelProperty(value = "发电量(各种求和结果字段)", required = true)
    private BigDecimal generateCapacity;//发电量(各种求和结果字段)
    @ApiModelProperty(value = "发电功率", required = true)
    private BigDecimal generationPower;//发电功率
    @ApiModelProperty(value = "日发电量", required = true)
    private BigDecimal todayGenerationPower;//日发电量
    @ApiModelProperty(value = "月发电量", required = true)
    private BigDecimal monthGenerationPower;//月发电量
    @ApiModelProperty(value = "年发电量", required = true)
    private BigDecimal yearGenerationPower;//年发电量
    @ApiModelProperty(value = "总发电量", required = true)
    private BigDecimal totalGenerationPower;//总发电量
    @ApiModelProperty(value = "今日等效时数", required = true)
    private BigDecimal todayEquivalentAging;//今日等效时数
    @ApiModelProperty(value = "本月等效时数", required = true)
    private BigDecimal monthEquivalentAging;//本月等效时数
    @ApiModelProperty(value = "当前输入功率(KW)", required = true)
    private BigDecimal inputPower;//输入功率(KW)
    @ApiModelProperty(value = "当前输出功率(KW)", required = true)
    private BigDecimal outputPower;//输出功率(KW)

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

    public BigDecimal getInstalledCapacity() {
        return installedCapacity;
    }

    public void setInstalledCapacity(BigDecimal installedCapacity) {
        this.installedCapacity = installedCapacity;
    }

    public BigDecimal getGenerationPower() {
        return generationPower;
    }

    public void setGenerationPower(BigDecimal generationPower) {
        this.generationPower = generationPower;
    }

    public BigDecimal getTodayGenerationPower() {
        return todayGenerationPower;
    }

    public void setTodayGenerationPower(BigDecimal todayGenerationPower) {
        this.todayGenerationPower = todayGenerationPower;
    }

    public BigDecimal getMonthGenerationPower() {
        return monthGenerationPower;
    }

    public void setMonthGenerationPower(BigDecimal monthGenerationPower) {
        this.monthGenerationPower = monthGenerationPower;
    }

    public BigDecimal getYearGenerationPower() {
        return yearGenerationPower;
    }

    public void setYearGenerationPower(BigDecimal yearGenerationPower) {
        this.yearGenerationPower = yearGenerationPower;
    }

    public BigDecimal getTotalGenerationPower() {
        return totalGenerationPower;
    }

    public void setTotalGenerationPower(BigDecimal totalGenerationPower) {
        this.totalGenerationPower = totalGenerationPower;
    }

    public BigDecimal getTodayEquivalentAging() {
        return todayEquivalentAging;
    }

    public void setTodayEquivalentAging(BigDecimal todayEquivalentAging) {
        this.todayEquivalentAging = todayEquivalentAging;
    }

    public BigDecimal getMonthEquivalentAging() {
        return monthEquivalentAging;
    }

    public void setMonthEquivalentAging(BigDecimal monthEquivalentAging) {
        this.monthEquivalentAging = monthEquivalentAging;
    }

    public BigDecimal getGenerateCapacity() {
        return generateCapacity;
    }

    public void setGenerateCapacity(BigDecimal generateCapacity) {
        this.generateCapacity = generateCapacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getInputPower() {
        return inputPower;
    }

    public void setInputPower(BigDecimal inputPower) {
        this.inputPower = inputPower;
    }

    public BigDecimal getOutputPower() {
        return outputPower;
    }

    public void setOutputPower(BigDecimal outputPower) {
        this.outputPower = outputPower;
    }
}
