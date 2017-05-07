package com.photovoltaic.service.devicemanager.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.dao.device.InverterDeviceDAO;
import com.photovoltaic.model.device.TabInverterDevice;
import com.photovoltaic.service.devicemanager.IInverterDeviceManagerService;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.out.inveter.InverterInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器设备管理service
 */
@Service
public class InverterDeviceManagerService implements IInverterDeviceManagerService {

    private static final Logger logger = LoggerFactory.getLogger(InverterDeviceManagerService.class);

    @Autowired
    private InverterDeviceDAO inverterDeviceDAO;

    @Override
    public JsonResultOut<List<InverterInfoDTO>> getInverterDeviceList(CommonQueryInModel inModel) {
        Map<String, Object> queryParamsMap = new HashMap<>();
        int pageStart = (inModel.getPageNum()-1)*inModel.getPageNum();
        List<TabInverterDevice> inverterDeviceList = inverterDeviceDAO.getInverterDeviceList(pageStart, inModel.getPageSize(), queryParamsMap);

        List<InverterInfoDTO> inverterInfoList = new ArrayList<>();

        inverterDeviceList.forEach(tabInverterDevice -> inverterInfoList.add(new InverterInfoDTO(tabInverterDevice)));

        return new JsonResultOut(ReturnCode.SUCCESS, "获取逆变器列表成功!", inverterInfoList);
    }
}
