package com.photovoltaic.service.devicemanager.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.dao.device.PowerStationDAO;
import com.photovoltaic.model.device.TabPowerStation;
import com.photovoltaic.service.devicemanager.IPowerStationManagerService;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonDeleteInModel;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.PowerStationInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.PowerStationInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/5/7.
 * 电站管理service
 */
@Service
public class PowerStationManagerService implements IPowerStationManagerService {

    @Autowired
    private PowerStationDAO powerStationDAO;

    @Override
    public JsonResultOut<List<PowerStationInfoDTO>> getPowerStationList(CommonQueryInModel inModel) {
        Map<String, Object> queryParamsMap = new HashMap<>();
        int pageStart = (inModel.getPageNum()-1)*inModel.getPageNum();
        List<TabPowerStation> powerStationList = powerStationDAO.getPowerStationList(pageStart, inModel.getPageSize(), queryParamsMap);

        List<PowerStationInfoDTO> powerStationInfoList = new ArrayList<>();

        powerStationList.forEach(tabPowerStation -> powerStationInfoList.add(new PowerStationInfoDTO(tabPowerStation)));

        return new JsonResultOut(ReturnCode.SUCCESS, "获取电站列表成功!", powerStationInfoList);
    }

    @Override
    public JsonResultOut insertOrUpdatePowerStationInfo(PowerStationInfoAddInModel inModel) {
        if(inModel.getPowerStationId()==0) {
            powerStationDAO.addPowerStationInfo(inModel);
        } else {
            powerStationDAO.updatePowerStationInfo(inModel);
        }
        return new JsonResultOut(ReturnCode.SUCCESS, "新增/更新电站信息成功!");
    }

    @Override
    public JsonResultOut<PowerStationInfoDTO> getPowerStationInfo(CommonSelectOneInModel inModel) {
        TabPowerStation tabPowerStation = powerStationDAO.getPowerStationById(inModel.getItemId());

        PowerStationInfoDTO powerStationInfoDTO = null;
        if(tabPowerStation!=null) {
            powerStationInfoDTO = new PowerStationInfoDTO(tabPowerStation);
        }
        return new JsonResultOut(ReturnCode.SUCCESS, "获取dtu设备信息成功!", powerStationInfoDTO);
    }

    @Override
    public JsonResultOut deletePowerStationInfo(CommonDeleteInModel inModel) {
        powerStationDAO.deletePowerStationById(inModel.getItemId());
        return new JsonResultOut(ReturnCode.SUCCESS, "删除电站信息成功!");
    }
}
