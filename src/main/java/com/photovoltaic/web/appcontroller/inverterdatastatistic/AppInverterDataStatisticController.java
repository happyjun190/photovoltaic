package com.photovoltaic.web.appcontroller.inverterdatastatistic;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.inverterdatastatistic.IAppInverterDataStatisticService;
import com.photovoltaic.web.controller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.BaseInModel;
import com.photovoltaic.web.model.in.auth.RegistInModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wushenjun on 2017/4/16.
 * app数据分析controller
 */
@Api(tags = "Inverter Data")
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
    @ApiOperation(value = "获取首页数据分析概览", tags="wushenjun", notes = "获取首页数据分析概览")
    @RequestMapping(value = "/getStatisticOverView/{version}", method = RequestMethod.POST)
    public JsonResultOut<Map<String, Object>> getStatisticOverView(HttpServletRequest request,
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
    public JsonResultOut<Map<String, Object>> getPowerStaticInfo(HttpServletRequest request,
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
    @ApiOperation(value = "获取用户的逆变器列表", tags="wushenjun", notes = "获取用户的逆变器列表")
    @RequestMapping(value = "/getInverterInfoList/{version}", method = RequestMethod.POST)
    public JsonResultOut<Map<String, Object>> getInverterInfoList(HttpServletRequest request,
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


}
