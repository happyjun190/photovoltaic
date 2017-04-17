package com.photovoltaic.service.inverterdatastatistic.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.commons.util.DateUtils;
import com.photovoltaic.dao.inverter.InverterDataStatisticDAO;
import com.photovoltaic.dao.inverter.TodaySummaryDataDAO;
import com.photovoltaic.model.device.TabInverterDevice;
import com.photovoltaic.model.inverterdata.TabInverterRealtimeData;
import com.photovoltaic.model.inverterdata.TabTodaySummary;
import com.photovoltaic.model.powerstation.TabPowerStation;
import com.photovoltaic.service.inverterdatastatistic.IAppInverterDataStatisticService;
import com.photovoltaic.web.dto.inverter.HomePageOverViewDTO;
import com.photovoltaic.web.dto.inverter.InverterInfoDTO;
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
    @Autowired
    private TodaySummaryDataDAO todaySummaryDataDAO;

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
    public JsonResult getInverterInfoList(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        logger.info("userId:{}", userId);

        //获取用户所有的电站id list
        List<String> powerStationIdList = inverterDataStatisticDAO.getUsersPowerStationIdList(userId);

        //获取用户所能查看数据的逆变器Id(用户->电站->dtu设备->逆变器设备)
        List<String> inverterIdList = inverterDataStatisticDAO.getUsersInverterIdList(powerStationIdList);

        //获取用户所能查看数据的逆变器(用户->电站->dtu设备->逆变器设备)
        List<TabInverterDevice> inverterDeviceList = inverterDataStatisticDAO.getUsersInverterDeviceList(powerStationIdList);

        //当日的YYYYMMDD格式时间
        String todayDate = DateUtils.getNowTime(DateUtils.DATE_DAY_STR);
        String month = DateUtils.getNowTime(DateUtils.DATE_JFP_STR);
        String monthStartDate = month+"01";
        String monthEndDate = month+"31";
        String year = DateUtils.getNowTime("yyyy");
        String yearStartDate = year+"0101";
        String yearEndDate = year+"1231";

        //获取当天逆变器信息
        Map<String, InverterInfoDTO> todayInverterInfoMap = todaySummaryDataDAO.getInverterInfoMapByTimeInterval(inverterIdList, todayDate, todayDate);
        //获取当月逆变器信息
        Map<String, InverterInfoDTO> monthInverterInfoMap = todaySummaryDataDAO.getInverterInfoMapByTimeInterval(inverterIdList, monthStartDate, monthEndDate);
        //获取当年逆变器信息
        Map<String, InverterInfoDTO> yearInverterInfoMap = todaySummaryDataDAO.getInverterInfoMapByTimeInterval(inverterIdList, yearStartDate, yearEndDate);

        //获取用户所有逆变器的最近一条实时统计数据(当天的)
        List<TabInverterRealtimeData> inverterRealtimeDataList = inverterDataStatisticDAO.getUserLatelyInverterRealtimeDataList(inverterIdList, todayDate);
        Map<String, TabInverterRealtimeData> inverterRealtimeDataMap = new HashMap<>();
        for(TabInverterRealtimeData tabInverterRealtimeData:inverterRealtimeDataList) {
            inverterRealtimeDataMap.put(tabInverterRealtimeData.getInverterId(), tabInverterRealtimeData);
        }

        InverterInfoDTO todayInverterInfoDTO;
        InverterInfoDTO monthInverterInfoDTO;
        InverterInfoDTO yearInverterInfoDTO;
        TabInverterRealtimeData tabInverterRealtimeData;
        //结果列表
        List<InverterInfoDTO> inverterInfoList = new ArrayList<>();
        //组装各项统计数据
        for(TabInverterDevice tabInverterDevice: inverterDeviceList) {
            todayInverterInfoDTO = todayInverterInfoMap.getOrDefault(tabInverterDevice.getId(), new InverterInfoDTO());
            monthInverterInfoDTO = monthInverterInfoMap.getOrDefault(tabInverterDevice.getId(), new InverterInfoDTO());
            yearInverterInfoDTO = yearInverterInfoMap.getOrDefault(tabInverterDevice.getId(), new InverterInfoDTO());
            tabInverterRealtimeData = inverterRealtimeDataMap.getOrDefault(tabInverterDevice.getId(), new TabInverterRealtimeData());

            todayInverterInfoDTO.setTodayGenerationPower(todayInverterInfoDTO.getGenerateCapacity());
            todayInverterInfoDTO.setMonthGenerationPower(monthInverterInfoDTO.getGenerateCapacity());
            todayInverterInfoDTO.setYearGenerationPower(yearInverterInfoDTO.getGenerateCapacity());
            todayInverterInfoDTO.setInverterName(tabInverterDevice.getName());
            todayInverterInfoDTO.setInstalledCapacity(tabInverterDevice.getPowerSize());
            todayInverterInfoDTO.setGenerationPower(tabInverterRealtimeData.getOutputPower());
            todayInverterInfoDTO.setTodayEquivalentAging(new BigDecimal("0.86"));
            todayInverterInfoDTO.setMonthEquivalentAging(new BigDecimal(600));

            inverterInfoList.add(todayInverterInfoDTO);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("inverterInfoList", inverterInfoList);
        //getInverterInfoMapByTimeInterval

        return new JsonResult(ReturnCode.SUCCESS, "获取逆变器列表成功!", resultMap);
    }
}
