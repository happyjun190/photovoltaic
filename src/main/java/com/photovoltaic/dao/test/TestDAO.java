package com.photovoltaic.dao.test;

import com.photovoltaic.model.test.TabTest;
import com.photovoltaic.repositories.GftwRepositories;

import java.util.List;

/**
 * Created by wushenjun on 2017/3/6.
 * 用于测试框架连接Oracle 数据库
 */
public interface TestDAO {

    /**
     * 获取测试数据列表
     * @return
     */
    List<TabTest> getTestDataList();

}
