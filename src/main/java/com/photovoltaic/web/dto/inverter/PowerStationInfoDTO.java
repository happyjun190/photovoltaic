package com.photovoltaic.web.dto.inverter;

import com.photovoltaic.model.powerstation.TabPowerStation;

/**
 * Created by ziye on 2017/4/16.
 */
public class PowerStationInfoDTO {
    private String powerStationId;//电站id
    private String powerStationName;//电站名称

    public PowerStationInfoDTO(){}
    public PowerStationInfoDTO(TabPowerStation tabPowerStation) {
        powerStationId = tabPowerStation.getId();
        powerStationName = tabPowerStation.getName();
    }

    public String getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(String powerStationId) {
        this.powerStationId = powerStationId;
    }

    public String getPowerStationName() {
        return powerStationName;
    }

    public void setPowerStationName(String powerStationName) {
        this.powerStationName = powerStationName;
    }
}
