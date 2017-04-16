package com.photovoltaic.service.inverterdatastatistic;

import com.photovoltaic.commons.json.JsonResult;

import java.util.Map;

/**
 * Created by wushenjun on 2017/4/16.
 * app端数据展示用interface
 */
public interface IAppInverterDataStatisticService {

    /**
     * 获取数据分析概览
     * @param map
     * @return
     */
    JsonResult getStatisticOverView(Map<String, Object> map);


    /**
     * 获取用户的电站列表
     * @param map
     * @return
     */
    JsonResult getPowerStaticInfo(Map<String, Object> map);

}
