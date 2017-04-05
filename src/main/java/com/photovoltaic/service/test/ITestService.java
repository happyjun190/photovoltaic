package com.photovoltaic.service.test;

import com.photovoltaic.commons.json.JsonResult;

import java.io.IOException;
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


    /**
     * 添加数据
     * @param map
     * @return
     */
    JsonResult insertTest(Map<String, Object> map);


    /**
     * 更新数据
     * @param map
     * @return
     */
    JsonResult updateTest(Map<String, Object> map);


    /**
     * 删除数据
     * @param map
     * @return
     */
    JsonResult deleteTest(Map<String, Object> map);

}
