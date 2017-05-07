package com.photovoltaic.model.device;

import com.photovoltaic.model.BaseModel;

/**
 * Created by wushenjun on 2017/4/16.
 */
public class TabPowerStation extends BaseModel {
    private int id;
    private int areaId;//区域id，ts_areas表id//TODO 后期可能需要改为area_code

    private String areaName;//区域名称

    private String name;//发电站名称
    private int ownerId;//所有者ID，ts_user_info表id

    private String ownerName;//所有者姓名

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
