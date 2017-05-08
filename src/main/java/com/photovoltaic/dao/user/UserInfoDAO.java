package com.photovoltaic.dao.user;


import com.photovoltaic.model.user.TabUserInfo;
import com.photovoltaic.web.model.in.user.UserInfoAddInModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select T1.\"ID\" FROM \"TS_USER_INFO\" T1 where T1.\"LOGIN_NAME\" = #{loginName} ")
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

    /**
     * admin后台新增用户
     * @param inModel
     */
    void adminAddUserInfo(UserInfoAddInModel inModel);


    /**
     * admin后台更新用户
     * @param inModel
     */
    void adminUpdateUserInfo(UserInfoAddInModel inModel);


    /**
     * 通过userId 获取用户信息
     * @param userId
     * @return
     */
    TabUserInfo getUserInfoByUserId(@Param("userId")int userId);


    /**
     * 更新用户密码
     * @param userId
     * @param password
     */
    @Update("UPDATE TS_USER_INFO SET PASSWORD=#{password} WHERE ID = #{userId}")
    void updateUserPwd(@Param("userId")int userId, @Param("password")String password);

}
