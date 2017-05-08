package com.photovoltaic.web.appcontroller.statistic;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.service.statistic.IAppInverterDataStatisticService;
import com.photovoltaic.web.controller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.BaseInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.inverter.InverterStatisticInModel;
import com.photovoltaic.web.model.out.inveter.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wushenjun on 2017/4/16.
 * app数据分析controller
 */
@Api(tags = "App Inverter Data")
@RestController
@RequestMapping("/app/statistic")
public class AppInverterDataStatisticController extends BaseController{


    @Autowired
    private IAppInverterDataStatisticService appInverterDataStatisticService;


    /**
     * 获取首页数据分析概览
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取首页数据分析概览(光伏总览)", tags="wushenjun", notes = "获取首页数据分析概览(光伏总览)")
    @RequestMapping(value = "/getStatisticOverView/{version}", method = RequestMethod.POST)
    public JsonResultOut<HomePageOverViewDTO> getStatisticOverView(HttpServletRequest request,
                                                                   @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                   @ApiParam(value = "用户token信息", required = true) @RequestBody BaseInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getStatisticOverView(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取电站数据概览失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取用户的电站列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取用户的电站列表", tags="wushenjun", notes = "获取用户的电站列表")
    @RequestMapping(value = "/getPowerStaticInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<PowerStationInfoDTO>> getPowerStaticInfo(HttpServletRequest request,
                                                                       @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                       @ApiParam(value = "用户token信息", required = true) @RequestBody BaseInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getPowerStaticInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取电站列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取用户的逆变器列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取用户的逆变器列表(逆变器矩阵)", tags="wushenjun", notes = "获取用户的逆变器列表(逆变器矩阵)")
    @RequestMapping(value = "/getInverterInfoList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<InverterInfoDTO>> getInverterInfoList(HttpServletRequest request,
                                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                    @ApiParam(value = "用户token信息", required = true) @RequestBody BaseInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getInverterInfoList(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取逆变器列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取逆变器分析信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取用户的逆变器设备分析列表(设备分析结果页)", tags="wushenjun", notes = "获取用户的逆变器设备分析列表(设备分析结果页)")
    @RequestMapping(value = "/getInverterStatisticList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<InverterStatisticDTO>> getInverterStatisticList(HttpServletRequest request,
                                                                              @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                              @ApiParam(value = "用户token信息及类型", required = true) @RequestBody InverterStatisticInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getInverterStatisticList(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取逆变器分析信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取逆变器详情
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取逆变器详细信息(智能监控-设备列表-设备明细功能)", tags="wushenjun", notes = "获取逆变器详细信息(智能监控-设备列表-设备明细功能)")
    @RequestMapping(value = "/getInverterRuningDetailInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut<InverterRuningDetailDTO> getInverterRuningDetailInfo(HttpServletRequest request,
                                                                              @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                              @ApiParam(value = "逆变器id信息", required = true) @RequestBody CommonSelectOneInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getInverterRuningDetailInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取逆变器详情失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }



}
