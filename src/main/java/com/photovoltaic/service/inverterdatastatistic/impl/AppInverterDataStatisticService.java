package com.photovoltaic.service.inverterdatastatistic.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.commons.util.DateUtils;
import com.photovoltaic.dao.inverter.InverterDataStatisticDAO;
import com.photovoltaic.model.inverterdata.TabInverterRealtimeData;
import com.photovoltaic.model.inverterdata.TabTodaySummary;
import com.photovoltaic.model.powerstation.TabPowerStation;
import com.photovoltaic.service.inverterdatastatistic.IAppInverterDataStatisticService;
import com.photovoltaic.web.dto.inverter.HomePageOverViewDTO;
import com.photovoltaic.web.dto.inverter.PowerStationInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/4/16.
 * app端数据展示用service
 */
@Service
public class AppInverterDataStatisticService implements IAppInverterDataStatisticService {

    private final static Logger logger = LoggerFactory.getLogger(AppInverterDataStatisticService.class);

    @Autowired
    private InverterDataStatisticDAO inverterDataStatisticDAO;

    @Override
    public JsonResult getStatisticOverView(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        logger.info("userId:{}", userId);

        //获取用户所有的电站id list
        List<String> powerStationIdList = inverterDataStatisticDAO.getUsersPowerStationIdList(userId);

        //获取用户所能查看数据的逆变器Id(用户->电站->dtu设备->逆变器设备)
        List<String> inverterIdList = inverterDataStatisticDAO.getUsersInverterIdList(powerStationIdList);

        String todayDate = DateUtils.getNowTime(DateUtils.DATE_DAY_STR);
        //获取用户所有逆变器的最近一条实时统计数据(当天的)
        List<TabInverterRealtimeData> inverterRealtimeDataList = inverterDataStatisticDAO.getUserLatelyInverterRealtimeDataList(inverterIdList, todayDate);

        //获取用户所有逆变器的当天的统计数据
        List<TabTodaySummary>  toDaySummaryList = inverterDataStatisticDAO.getUserToDaySummaryList(inverterIdList, todayDate);

        //TODO 计算，暂时不用sql计算
        BigDecimal generationEfficiency = new BigDecimal(0.68);//发电效率
        BigDecimal totalGenerationPower = new BigDecimal(0);//总发电量
        BigDecimal todayGenerationPower = new BigDecimal(0);//今日发电量
        BigDecimal currentInputPower = new BigDecimal(0);//当前输入功率
        BigDecimal currentOutputPower = new BigDecimal(0);//当前输出功率
        BigDecimal todayCO2Reduction = new BigDecimal(0);//当日CO2减排量
        BigDecimal totalCO2Reduction = new BigDecimal(0);//累计CO2减排量
        BigDecimal equivalentAging = new BigDecimal(4.5);//等效时效
        BigDecimal profit = new BigDecimal(888.88);//收益//TODO 收益从哪里取得, 先从省钱获取

        //TODO 各种if，到时候需要用sql sum函数进行统计，这样代码太乱
        for(TabTodaySummary tabTodaySummary:toDaySummaryList) {
            if(tabTodaySummary.getTotalGenerateCapacity()!=null) {
                totalGenerationPower = totalGenerationPower.add(tabTodaySummary.getTotalGenerateCapacity());
            }
            if(tabTodaySummary.getGenerateCapacity()!=null) {
                todayGenerationPower = todayGenerationPower.add(tabTodaySummary.getGenerateCapacity());
            }
            if(tabTodaySummary.getCo2Reduction()!=null) {
                todayCO2Reduction = todayCO2Reduction.add(tabTodaySummary.getCo2Reduction());
            }
            if(tabTodaySummary.getTotalCo2Reduction()!=null) {

                totalCO2Reduction = totalCO2Reduction.add(tabTodaySummary.getTotalCo2Reduction());
            }
            if(tabTodaySummary.getSaveMoney()!=null) {
                profit = profit.add(tabTodaySummary.getSaveMoney());
            }
        }

        for(TabInverterRealtimeData tabInverterRealtimeData:inverterRealtimeDataList) {
            if(tabInverterRealtimeData.getInputPower()!=null) {
                currentInputPower = currentInputPower.add(tabInverterRealtimeData.getInputPower());
            }
            if(tabInverterRealtimeData.getOutputPower()!=null) {
                currentOutputPower = currentOutputPower.add(tabInverterRealtimeData.getOutputPower());
            }
        }


        HomePageOverViewDTO homePageOverViewDTO = new HomePageOverViewDTO();
        homePageOverViewDTO.setGenerationEfficiency(generationEfficiency);//TODO 发电效率 待补充
        homePageOverViewDTO.setTotalGenerationPower(totalGenerationPower);
        homePageOverViewDTO.setTodayGenerationPower(todayGenerationPower);
        homePageOverViewDTO.setCurrentInputPower(currentInputPower);
        homePageOverViewDTO.setCurrentOutputPower(currentOutputPower);
        homePageOverViewDTO.setTotalCO2Reduction(totalCO2Reduction);
        homePageOverViewDTO.setTodayCO2Reduction(todayCO2Reduction);
        homePageOverViewDTO.setEquivalentAging(equivalentAging);
        homePageOverViewDTO.setProfit(profit);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("homePageOverViewInfo", homePageOverViewDTO);


        //resultMap.put("inverterRealtimeDataList", inverterRealtimeDataList);

        return new JsonResult(ReturnCode.SUCCESS, "获取电站概览数据成功!", resultMap);
    }


    @Override
    public JsonResult getPowerStaticInfo(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        List<TabPowerStation> powerStationList = inverterDataStatisticDAO.getUsersPowerStationList(userId);

        List<PowerStationInfoDTO> powerStationInfoList = new ArrayList<>();
        for(TabPowerStation tabPowerStation:powerStationList) {
            powerStationInfoList.add(new PowerStationInfoDTO(tabPowerStation));
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("powerStationList", powerStationInfoList);
        return new JsonResult(ReturnCode.SUCCESS, "获取电站列表成功!", resultMap);
    }


    @Override
    public JsonResult getInverterInfo(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        logger.info("userId:{}", userId);

        //获取用户所有的电站id list
        List<String> powerStationIdList = inverterDataStatisticDAO.getUsersPowerStationIdList(userId);

        //获取用户所能查看数据的逆变器Id(用户->电站->dtu设备->逆变器设备)
        List<String> inverterIdList = inverterDataStatisticDAO.getUsersInverterIdList(powerStationIdList);
        return null;
    }
}
