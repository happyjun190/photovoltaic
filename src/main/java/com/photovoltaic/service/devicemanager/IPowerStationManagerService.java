package com.photovoltaic.service.devicemanager;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import com.photovoltaic.web.model.in.devicemanager.PowerStationInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.DtuDeviceInfoDTO;
import com.photovoltaic.web.model.out.devicemanager.PowerStationInfoDTO;

import java.util.List;

/**
 * Created by wushenjun on 2017/5/7.
 * 电站管理interface
 */
public interface IPowerStationManagerService {
    /**
     * 获取电站列表
     * @param inModel
     * @return
     */
    JsonResultOut<List<PowerStationInfoDTO>> getPowerStationList(CommonQueryInModel inModel);


    /**
     * 新增或更新电站信息
     * @param inModel
     * @return
     */
    JsonResultOut insertOrUpdatePowerStationInfo(PowerStationInfoAddInModel inModel);


    /**
     * 获取指定电站信息
     * @param inModel
     * @return
     */
    JsonResultOut<PowerStationInfoDTO> getPowerStationInfo(CommonSelectOneInModel inModel);
}
