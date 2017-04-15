package com.photovoltaic.dao.user;


import com.photovoltaic.model.user.TabUserInfo;
import org.apache.ibatis.annotations.Param;

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


}
