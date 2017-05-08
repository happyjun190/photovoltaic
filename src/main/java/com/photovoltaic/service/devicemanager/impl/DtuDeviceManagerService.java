package com.photovoltaic.service.devicemanager.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.dao.device.DtuDeviceDAO;
import com.photovoltaic.model.device.TabDtuDevice;
import com.photovoltaic.model.device.TabInverterDevice;
import com.photovoltaic.service.devicemanager.IDtuDeviceManagerService;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonDeleteInModel;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.DtuDeviceInfoDTO;
import com.photovoltaic.web.model.out.devicemanager.InverterInfoOutModel;
import com.photovoltaic.web.model.out.inveter.InverterInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * dtu设备管理service
 */
@Service
public class DtuDeviceManagerService implements IDtuDeviceManagerService {

    @Autowired
    private DtuDeviceDAO dtuDeviceDAO;

    @Override
    public JsonResultOut<List<DtuDeviceInfoDTO>> getDtuDeviceList(CommonQueryInModel inModel) {
        Map<String, Object> queryParamsMap = new HashMap<>();
        int pageStart = (inModel.getPageNum()-1)*inModel.getPageNum();
        List<TabDtuDevice> dtuDeviceList = dtuDeviceDAO.getDtuDeviceList(pageStart, inModel.getPageSize(), queryParamsMap);

        List<DtuDeviceInfoDTO> deviceInfoList = new ArrayList<>();

        dtuDeviceList.forEach(tabDtuDevice -> deviceInfoList.add(new DtuDeviceInfoDTO(tabDtuDevice)));

        return new JsonResultOut(ReturnCode.SUCCESS, "获取dtu设备列表成功!", deviceInfoList);
    }

    @Override
    public JsonResultOut insertOrUpdateDtuDeviceInfo(DtuDeviceInfoAddInModel inModel) {
        if(inModel.getDtuId()==0) {
            TabDtuDevice tabDtuDevice = dtuDeviceDAO.getDtuDeviceByAuthKey(inModel.getAuthKey());
            if(tabDtuDevice!=null) {
                return new JsonResultOut(ReturnCode.PARAMSERROR, "已经存在相同authKey的dtu设备!");
            }
            dtuDeviceDAO.addDtuDeviceInfo(inModel);
        } else {
            dtuDeviceDAO.updateDtuDeviceInfo(inModel);
        }
        return new JsonResultOut(ReturnCode.SUCCESS, "新增/更新dtu设备信息成功!");
    }

    @Override
    public JsonResultOut<DtuDeviceInfoDTO> getDtuDeviceInfo(CommonSelectOneInModel inModel) {
        TabDtuDevice tabDtuDevice = dtuDeviceDAO.getDtuDeviceById(inModel.getItemId());

        DtuDeviceInfoDTO dtuDeviceInfoDTO = null;
        if(tabDtuDevice!=null) {
            dtuDeviceInfoDTO = new DtuDeviceInfoDTO(tabDtuDevice);
        }
        return new JsonResultOut(ReturnCode.SUCCESS, "获取dtu设备信息成功!", dtuDeviceInfoDTO);
    }


    @Override
    public JsonResultOut deleteDtuDeviceInfo(CommonDeleteInModel inModel) {
        dtuDeviceDAO.deleteDtuDeviceInfoById(inModel.getItemId());
        return new JsonResultOut(ReturnCode.SUCCESS, "删除dtu设备信息成功!");
    }
}
