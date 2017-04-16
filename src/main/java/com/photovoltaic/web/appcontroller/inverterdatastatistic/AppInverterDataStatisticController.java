package com.photovoltaic.web.appcontroller.inverterdatastatistic;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.inverterdatastatistic.IAppInverterDataStatisticService;
import com.photovoltaic.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wushenjun on 2017/4/16.
 * app数据分析controller
 */
@RestController
@RequestMapping("/app/statastatistic")
public class AppInverterDataStatisticController extends BaseController{


    @Autowired
    private IAppInverterDataStatisticService appInverterDataStatisticService;


    /**
     * 获取数据分析概览
     * @param request
     * @param map
     * @param version
     * @return
     */
    @RequestMapping(value = "/getStatisticOverView/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult getStatisticOverView(HttpServletRequest request,
                     @RequestBody Map<String, Object> map,
                     @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getStatisticOverView(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "获取电站数据概览失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取用户的电站列表
     * @param request
     * @param map
     * @param version
     * @return
     */
    @RequestMapping(value = "/getPowerStaticInfo/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult getPowerStaticInfo(HttpServletRequest request,
                                    @RequestBody Map<String, Object> map,
                                    @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = appInverterDataStatisticService.getPowerStaticInfo(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "获取电站列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


}
