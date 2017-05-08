package com.photovoltaic.dao.device;

import com.photovoltaic.model.device.TabDtuDevice;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * dtu设备DAO
 */
@Mapper
public interface DtuDeviceDAO {
    /**
     * 分页查询dtu设备信息
     * @param pageStart
     * @param pageSize
     * @param queryParamsMap
     * @return
     */
    List<TabDtuDevice> getDtuDeviceList(@Param("pageStart")int pageStart,
                                             @Param("pageSize")int pageSize,
                                             @Param("queryParams")Map<String, Object> queryParamsMap);


    /**
     * 根据dtu id获取dtu信息
     * @param dtuId
     * @return
     */
    TabDtuDevice getDtuDeviceById(@Param("dtuId")int dtuId);


    /**
     * 根据dtu autk key获取dtu信息
     * @param authKey
     * @return
     */
    TabDtuDevice getDtuDeviceByAuthKey(@Param("authKey")String authKey);


    /**
     * 新增dtu设备信息
     * @param inModel
     */
    void addDtuDeviceInfo(DtuDeviceInfoAddInModel inModel);


    /**
     * 更新dtu设备信息
     * @param inModel
     */
    void updateDtuDeviceInfo(DtuDeviceInfoAddInModel inModel);


    /**
     * 删除dtu设备信息
     * @param dtuId
     */
    @Delete("DELETE FROM GFTW.\"TS_DTU_DEVICE\" WHERE \"id\" = #{dtuId}")
    void deleteDtuDeviceInfoById(@Param("dtuId")int dtuId);
}
