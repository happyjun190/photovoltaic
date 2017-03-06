package com.photovoltaic.service.test.impl;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.dao.test.TestDAO;
import com.photovoltaic.model.test.TabTest;
import com.photovoltaic.service.test.ITestService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/3/6.
 * 测试service
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public JsonResult getTestDataList(Map<String, Object> map) {
        List<TabTest> testDataList = testDAO.getTestDataList();

        Map<String, Object> resultMap = new HashedMap();
        resultMap.put("testDataList", testDataList);
        return new JsonResult(ReturnCode.SUCCESS, "获取测试数据列表成功!", resultMap);
    }
}
