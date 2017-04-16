package com.photovoltaic.dao.inverter;

import com.photovoltaic.model.inverter.TabInverterRealtimeData;
import com.photovoltaic.model.inverter.TabTodaySummary;
import com.photovoltaic.model.powerstation.TabPowerStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by wushenjun on 2017/4/16.
 */
@Mapper
public interface InverterDataStatisticDAO {

    /**
     * 获取用户所有的电站id list
     * @param userId
     * @return
     */
    @Cacheable(value = "getUsersPowerStationIdList")
    @Select("SELECT T1.\"id\" FROM \"GFTW\".\"ts_power_station\" T1 where T1.\"ownerId\" = #{userId}")
    List<String> getUsersPowerStationIdList(@Param("userId") String userId);


    /**
     * 获取用户所有的电站
     * @param userId
     * @return
     */
    List<TabPowerStation> getUsersPowerStationList(@Param("userId") String userId);


    /**
     * 获取用户所能查看数据的逆变器Id(用户->电站->dtu设备->逆变器设备)
     * @param powerStationIdList
     * @return
     */
    @Cacheable(value = "getUsersInverterIdList")
    List<String> getUsersInverterIdList(@Param("powerStationIdList") List<String> powerStationIdList);


    /**
     * 获取用户所有逆变器的最近一条实时统计数据(当天的)
     * @param inverterIdList
     * @return
     */
    List<TabInverterRealtimeData> getUserLatelyInverterRealtimeDataList(@Param("inverterIdList") List<String> inverterIdList, @Param("toDayDate")String toDayDate);


    /**
     * 获取用户所有逆变器的当天的统计数据
     * @param inverterIdList
     * @param toDayDate
     * @return
     */
    List<TabTodaySummary> getUserToDaySummaryList(@Param("inverterIdList") List<String> inverterIdList, @Param("toDayDate")String toDayDate);


}
