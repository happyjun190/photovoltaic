package com.photovoltaic.web.model.in.inverter;

import com.photovoltaic.web.model.in.BaseInModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wushenjun on 2017/4/25.
 */
@ApiModel
public class InverterStatisticInModel extends BaseInModel {

    @ApiModelProperty(value = "图标统计类型(1、功率(逆变器的输出功率) " +
            "                              2、合计(合计：逆变器累计发电量总和) " +
            "                              3、日均(日均：逆变器日均发电量总和（虚拟）) " +
            "                              4、最大(最大：逆变器的最大累计发电量) " +
            "                              5、最小(最小：逆变器的最小累计发电量))", example="1", required = true)
    private int statisticType;//统计类型 1、功率 2、合计 3、日均 4、最大 5、最小

    public int getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(int statisticType) {
        this.statisticType = statisticType;
    }
}
