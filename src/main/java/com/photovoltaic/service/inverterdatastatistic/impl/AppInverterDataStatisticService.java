package com.photovoltaic.service.inverterdatastatistic.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.inverterdatastatistic.IAppInverterDataStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wushenjun on 2017/4/16.
 * app端数据展示用service
 */
@Service
public class AppInverterDataStatisticService implements IAppInverterDataStatisticService {

    private final static Logger logger = LoggerFactory.getLogger(AppInverterDataStatisticService.class);

    @Override
    public JsonResult getStatisticOverView(Map<String, Object> map) {
        String userId = (String) map.get("userId");
        logger.info("userId:{}", userId);
        return new JsonResult(ReturnCode.SUCCESS, "获取电站概览数据成功!");
    }
}
