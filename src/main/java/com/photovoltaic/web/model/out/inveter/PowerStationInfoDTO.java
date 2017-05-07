package com.photovoltaic.web.model.out.inveter;

import com.photovoltaic.model.device.TabPowerStation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ziye on 2017/4/16.
 */
@ApiModel
public class PowerStationInfoDTO {
    @ApiModelProperty(value = "电站id", required = true)
    private int powerStationId;//电站id
    @ApiModelProperty(value = "电站名称", required = true)
    private String powerStationName;//电站名称

    public PowerStationInfoDTO(){}
    public PowerStationInfoDTO(TabPowerStation tabPowerStation) {
        powerStationId = tabPowerStation.getId();
        powerStationName = tabPowerStation.getName();
    }

    public int getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(int powerStationId) {
        this.powerStationId = powerStationId;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }
}
