package com.photovoltaic.dao.device;

import com.photovoltaic.model.device.TabPowerStation;
import com.photovoltaic.web.model.in.devicemanager.PowerStationInfoAddInModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * 发电站DAO
 */
@Mapper
public interface PowerStationDAO {

    /**
     * 分页查询电站信息
     * @param pageStart
     * @param pageSize
     * @param queryParamsMap
     * @return
     */
    List<TabPowerStation> getPowerStationList(@Param("pageStart") int pageStart,
                                              @Param("pageSize") int pageSize,
                                              @Param("queryParams") Map<String, Object> queryParamsMap);


    /**
     * 根据powerStation id获取电站信息
     * @param powerStationId
     * @return
     */
    TabPowerStation getPowerStationById(@Param("powerStationId") int powerStationId);



    /**
     * 新增电站信息
     * @param inModel
     */
    void addPowerStationInfo(PowerStationInfoAddInModel inModel);


    /**
     * 更新电站信息
     * @param inModel
     */
    void updatePowerStationInfo(PowerStationInfoAddInModel inModel);
}
