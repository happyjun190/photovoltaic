package com.photovoltaic.web.dto.inverter;

import java.math.BigDecimal;

/**
 * Created by wushenjun on 2017/4/16.
 */
public class HomePageOverViewDTO {
    private BigDecimal generationEfficiency;//发电效率
    private BigDecimal totalGenerationPower;//总发电量
    private BigDecimal todayGenerationPower;//今日发电量
    private BigDecimal currentInputPower;//当前输入功率
    private BigDecimal currentOutputPower;//当前输出功率
    private BigDecimal todayCO2Reduction;//当日CO2减排量
    private BigDecimal totalCO2Reduction;//累计CO2减排量
    private BigDecimal equivalentAging;//等效时效

    private BigDecimal profit;//收益//TODO 收益从哪里取得

    public BigDecimal getGenerationEfficiency() {
        return generationEfficiency;
    }

    public void setGenerationEfficiency(BigDecimal generationEfficiency) {
        this.generationEfficiency = generationEfficiency;
    }

    public BigDecimal getTotalGenerationPower() {
        return totalGenerationPower;
    }

    public void setTotalGenerationPower(BigDecimal totalGenerationPower) {
        this.totalGenerationPower = totalGenerationPower;
    }

    public BigDecimal getTodayGenerationPower() {
        return todayGenerationPower;
    }

    public void setTodayGenerationPower(BigDecimal todayGenerationPower) {
        this.todayGenerationPower = todayGenerationPower;
    }

    public BigDecimal getCurrentInputPower() {
        return currentInputPower;
    }

    public void setCurrentInputPower(BigDecimal currentInputPower) {
        this.currentInputPower = currentInputPower;
    }

    public BigDecimal getCurrentOutputPower() {
        return currentOutputPower;
    }

    public void setCurrentOutputPower(BigDecimal currentOutputPower) {
        this.currentOutputPower = currentOutputPower;
    }

    public BigDecimal getTodayCO2Reduction() {
        return todayCO2Reduction;
    }

    public void setTodayCO2Reduction(BigDecimal todayCO2Reduction) {
        this.todayCO2Reduction = todayCO2Reduction;
    }

    public BigDecimal getTotalCO2Reduction() {
        return totalCO2Reduction;
    }

    public void setTotalCO2Reduction(BigDecimal totalCO2Reduction) {
        this.totalCO2Reduction = totalCO2Reduction;
    }

    public BigDecimal getEquivalentAging() {
        return equivalentAging;
    }

    public void setEquivalentAging(BigDecimal equivalentAging) {
        this.equivalentAging = equivalentAging;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }
}
