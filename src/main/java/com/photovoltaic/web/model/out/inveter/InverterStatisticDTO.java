package com.photovoltaic.web.model.out.inveter;

import com.photovoltaic.model.device.TabInverterDevice;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by wushenjun on 2017/4/25.
 */
@ApiModel
public class InverterStatisticDTO {

    @ApiModelProperty(value = "逆变器id", required = true)
    private int inverterId;//逆变器id
    @ApiModelProperty(value = "逆变器名称(x-轴名称)", required = true)
    private String inverterName;
    @ApiModelProperty(value = "y-轴统计值", required = true)
    private BigDecimal value;//y轴统计值

    public InverterStatisticDTO(){}

    public InverterStatisticDTO(TabInverterDevice tabInverterDevice) {
        inverterId = tabInverterDevice.getId();
        inverterName = tabInverterDevice.getName();
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
