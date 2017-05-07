package com.photovoltaic.dao.device;

import com.photovoltaic.model.device.TabInverterDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器设备DAO
 */
@Mapper
public interface InverterDeviceDAO {

    /**
     * 分页查询逆变器设备信息
     * @param pageStart
     * @param pageSize
     * @param queryParamsMap
     * @return
     */
    List<TabInverterDevice> getInverterDeviceList(@Param("pageStart")int pageStart,
                                                  @Param("pageSize")int pageSize,
                                                  @Param("queryParams")Map<String, Object> queryParamsMap);
}
