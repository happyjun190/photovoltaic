package com.photovoltaic.web.dto.inverter;

import java.math.BigDecimal;

/**
 * Created by wushenjun on 2017/4/17.
 * 逆变器综合信息DTO
 */
public class InverterInfoDTO {
    private String inverterId;//逆变器id
    private String inverterName;//逆变器名称
    private int status;//逆变器状态
    private BigDecimal installedCapacity;//装机容量
    private BigDecimal generateCapacity;//发电量(各种求和结果字段)
    private BigDecimal generationPower;//发电功率
    private BigDecimal todayGenerationPower;//日发电量
    private BigDecimal monthGenerationPower;//月发电量
    private BigDecimal yearGenerationPower;//年发电量
    private BigDecimal totalGenerationPower;//总发电量
    private BigDecimal todayEquivalentAging;//今日等效时数
    private BigDecimal monthEquivalentAging;//本月等效时数

    public String getInverterId() {
        return inverterId;
    }

    public void setInverterId(String inverterId) {
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
}
