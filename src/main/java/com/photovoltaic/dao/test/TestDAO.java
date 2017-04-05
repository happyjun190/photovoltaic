package com.photovoltaic.dao.test;

import com.photovoltaic.model.test.TabTest;
import com.photovoltaic.repositories.GftwRepositories;
import javafx.scene.control.Tab;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by wushenjun on 2017/3/6.
 * 用于测试框架连接Oracle 数据库
 */
public interface TestDAO {

    //TODO ATTENTION PLEASE:可以通过mapper.xml方式实现、也可以通过注解方式实现

    /**
     * 获取测试数据列表
     * @return
     */
    List<TabTest> getTestDataList();


    /**
     * 添加数据
     * @param tabTest
     */
    @Insert("INSERT INTO \"ts_test\" (\"id\", \"name\", \"phone\", \"address\", \"company\", \"note\", \"ctime\", \"mtime\") " +
            "                 VALUES (seq_on_tabtest.nextval, #{name}, #{phone}, #{address}, #{company}, #{note}, SYSDATE, SYSDATE) ")
    void insertTest(TabTest tabTest);


    /**
     * 更新数据
     * @param tabTest
     */
    @Update("UPDATE \"ts_test\" SET \"name\"=#{name}, \"phone\"=#{phone}, \"address\"=#{address}, \"company\"=#{company}, \"note\"=#{note}, \"mtime\"=SYSDATE WHERE \"id\" = #{id}")
    void updateTest(TabTest tabTest);


    /**
     * 删除数据
     * @param testId
     */
    @Delete("DELETE from \"ts_test\" where \"id\"=#{testId} ")
    void deleteTest(@Param("testId") int testId);

}
