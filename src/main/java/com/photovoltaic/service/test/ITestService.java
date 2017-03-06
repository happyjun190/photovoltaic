package com.photovoltaic.service.test;

import com.photovoltaic.commons.json.JsonResult;

import java.util.Map;

/**
 * Created by wushenjun on 2017/3/6.
 */
public interface ITestService {

    /**
     * 获取测试数据列表
     * @param map
     * @return
     */
    JsonResult getTestDataList(Map<String, Object> map);
}
