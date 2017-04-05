package com.photovoltaic.service.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.dao.test.TestDAO;
import com.photovoltaic.model.test.TabTest;
import com.photovoltaic.service.test.ITestService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/3/6.
 * 测试service
 */
@Service
public class TestService implements ITestService {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private TestDAO testDAO;

    @Override
    public JsonResult getTestDataList(Map<String, Object> map) {
        List<TabTest> testDataList = testDAO.getTestDataList();

        Map<String, Object> resultMap = new HashedMap();
        resultMap.put("testDataList", testDataList);
        return new JsonResult(ReturnCode.SUCCESS, "获取测试数据列表成功!", resultMap);
    }


    @Override
    public JsonResult insertTest(Map<String, Object> map) {
        Map<String, Object> testInfoMap = (Map<String, Object>) map.get("testInfo");
        TabTest tabTest = new TabTest();
        tabTest.setName((String) testInfoMap.getOrDefault("name", ""));
        tabTest.setPhone((String) testInfoMap.getOrDefault("phone", ""));
        tabTest.setAddress((String) testInfoMap.getOrDefault("address", ""));
        tabTest.setCompany((String) testInfoMap.getOrDefault("company", ""));
        tabTest.setNote((String) testInfoMap.getOrDefault("note", ""));
        testDAO.insertTest(tabTest);
        return new JsonResult(ReturnCode.SUCCESS, "新增测试数据成功!", null);
    }

    @Override
    public JsonResult updateTest(Map<String, Object> map) {
        Map<String, Object> testInfoMap = (Map<String, Object>) map.get("testInfo");
        TabTest tabTest = new TabTest();
        tabTest.setId((Integer) testInfoMap.getOrDefault("id", 0));
        tabTest.setName((String) testInfoMap.getOrDefault("name", ""));
        tabTest.setPhone((String) testInfoMap.getOrDefault("phone", ""));
        tabTest.setAddress((String) testInfoMap.getOrDefault("address", ""));
        tabTest.setCompany((String) testInfoMap.getOrDefault("company", ""));
        tabTest.setNote((String) testInfoMap.getOrDefault("note", ""));
        testDAO.updateTest(tabTest);
        return new JsonResult(ReturnCode.SUCCESS, "更新测试数据成功!", null);
    }

    @Override
    public JsonResult deleteTest(Map<String, Object> map) {
        int testId = (int) map.get("testId");
        testDAO.deleteTest(testId);
        return new JsonResult(ReturnCode.SUCCESS, "删除测试数据成功!", null);
    }
}
