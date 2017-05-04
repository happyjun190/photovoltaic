package com.photovoltaic.dao.user;


import com.photovoltaic.model.user.TabUserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by wushenjun on 2017/3/5.
 */
public interface UserInfoDAO {

    /**
     * 根据登录名获取用户信息
     * @param loginName
     * @return
     */
    TabUserInfo getUserInfoByLoginName(@Param("loginName")String loginName);


    /**
     * 新增用户信息(注册用)
     * @param tabUserInfo
     */
    void addUserInfo(TabUserInfo tabUserInfo);


    /**
     * 通过登录名获取用户id
     * @param loginName
     * @return
     */
    @Select("select t1.\"id\" FROM \"ts_user_info\" t1 where t1.\"loginName\" = #{loginName} ")
    String getUserIdByLoginName(@Param("loginName")String loginName);


    /**
     * 分页查询用户记录
     * @param pageStart
     * @param pageSize
     * @param queryParamsMap
     * @return
     */
    List<TabUserInfo> getUserInfoList(@Param("pageStart")int pageStart,
                                      @Param("pageSize")int pageSize,
                                      @Param("queryParams")Map<String, Object> queryParamsMap);

}
