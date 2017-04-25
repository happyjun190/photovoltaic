package com.photovoltaic.service.inverterdatastatistic;

import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.BaseInModel;
import com.photovoltaic.web.model.in.inverter.InverterStatisticInModel;


/**
 * Created by wushenjun on 2017/4/16.
 * app端数据展示用interface
 */
public interface IAppInverterDataStatisticService {

    /**
     * 获取数据分析概览
     * @param inModel
     * @return
     */
    JsonResultOut getStatisticOverView(BaseInModel inModel);


    /**
     * 获取用户的电站列表
     * @param inModel
     * @return
     */
    JsonResultOut getPowerStaticInfo(BaseInModel inModel);


    /**
     * 获取逆变器列表及发电信息
     * @param inModel
     * @return
     */
    JsonResultOut getInverterInfoList(BaseInModel inModel);


    /**
     * 获取逆变器各项参数数据分析列表
     * @param inModel
     * @return
     */
    JsonResultOut getInverterStatisticList(InverterStatisticInModel inModel);


}
