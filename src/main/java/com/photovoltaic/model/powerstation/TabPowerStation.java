package com.photovoltaic.model.powerstation;

import com.photovoltaic.model.BaseModel;

/**
 * Created by ziye on 2017/4/16.
 */
public class TabPowerStation extends BaseModel {
    private String id;
    private int areaId;//区域id，ts_areas表id//TODO 后期可能需要改为area_code
    private String name;//发电站名称
    private int ownerId;//所有者ID，ts_user_info表id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
