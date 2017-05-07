package com.photovoltaic.service.devicemanager;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.InverterInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.InverterInfoOutModel;
import com.photovoltaic.web.model.out.inveter.InverterInfoDTO;

import java.util.List;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器设备管理interface
 */
public interface IInverterDeviceManagerService {

    /**
     * 获取逆变器设备列表
     * @param inModel
     * @return
     */
    JsonResultOut<List<InverterInfoDTO>> getInverterDeviceList(CommonQueryInModel inModel);


    /**
     * 新增或更新逆变器信息
     * @param inModel
     * @return
     */
    JsonResultOut insertOrUpdateInverterInfo(InverterInfoAddInModel inModel);


    /**
     * 获取指定逆变器信息
     * @param inModel
     * @return
     */
    JsonResultOut<InverterInfoOutModel> getInverterInfo(CommonSelectOneInModel inModel);

}
