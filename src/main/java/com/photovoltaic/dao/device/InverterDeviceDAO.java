package com.photovoltaic.dao.device;

import com.photovoltaic.model.device.TabInverterDevice;
import com.photovoltaic.web.model.in.devicemanager.InverterInfoAddInModel;
import org.apache.ibatis.annotations.Delete;
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


    /**
     * 根据逆变器id获取逆变器信息
     * @param interverId
     * @return
     */
    TabInverterDevice getInverterDeviceById(@Param("inverterId")int interverId);

    /**
     * 新增逆变器设备信息
     * @param inModel
     */
    void addInverterDeviceInfo(InverterInfoAddInModel inModel);


    /**
     * 更新逆变器设备信息
     * @param inModel
     */
    void updateInverterDeviceInfo(InverterInfoAddInModel inModel);


    /**
     * 删除逆变器设备信息
     * @param inverterId
     */
    @Delete("DELETE FROM GFTW.\"TS_INVERTER_DEVICE\" WHERE \"id\" = #{inverterId}")
    void deleteInverterDeviceById(@Param("inverterId")int inverterId);

}
