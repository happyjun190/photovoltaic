package com.photovoltaic.service.devicemanager;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.DtuDeviceInfoDTO;

import java.util.List;

/**
 * Created by wushenjun on 2017/5/7.
 * dtu设备管理interface
 */
public interface IDtuDeviceManagerService {

    /**
     * 获取dtu设备列表
     * @param inModel
     * @return
     */
    JsonResultOut<List<DtuDeviceInfoDTO>> getDtuDeviceList(CommonQueryInModel inModel);


    /**
     * 新增或更新dtu设备信息
     * @param inModel
     * @return
     */
    JsonResultOut insertOrUpdateDtuDeviceInfo(DtuDeviceInfoAddInModel inModel);


    /**
     * 获取指定dtu设备信息
     * @param inModel
     * @return
     */
    JsonResultOut<DtuDeviceInfoDTO> getDtuDeviceInfo(CommonSelectOneInModel inModel);

}
