package com.photovoltaic.web.admincontroller.devicemanager;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.service.devicemanager.IDtuDeviceManagerService;
import com.photovoltaic.service.devicemanager.IPowerStationManagerService;
import com.photovoltaic.web.admincontroller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonDeleteInModel;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import com.photovoltaic.web.model.in.devicemanager.PowerStationInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.DtuDeviceInfoDTO;
import com.photovoltaic.web.model.out.devicemanager.PowerStationInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wushenjun on 2017/5/7.
 * 电站管理controller
 */
@Api(tags = "Admin PowerStation Manager")
@RestController
@RequestMapping("/admin/powerstation/")
public class PowerStationManagerController extends BaseController{

    @Autowired
    private IPowerStationManagerService powerStationManagerService;

    /**
     * 获取电站列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "分页获取电站列表，可供查询", tags="wushenjun", notes = "分页获取电站列表，可供查询")
    @RequestMapping(value = "getPowerStationList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<PowerStationInfoDTO>> getPowerStationList(HttpServletRequest request,
                                                                     @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                     @ApiParam(value = "分页查询电站列表参数", required = true) @RequestBody CommonQueryInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = powerStationManagerService.getPowerStationList(inModel);
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
     * 新增或更新电站信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "新增或更新电站信息", tags="wushenjun", notes = "新增或更新电站信息")
    @RequestMapping(value = "insertOrUpdatePowerStationInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut insertOrUpdatePowerStationInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "新增或更新电站所需信息", required = true) @RequestBody PowerStationInfoAddInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = powerStationManagerService.insertOrUpdatePowerStationInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "新增或更新电站信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取指定电站信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取指定电站信息", tags="wushenjun", notes = "获取指定电站信息")
    @RequestMapping(value = "getPowerStationInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut<PowerStationInfoDTO> getPowerStationInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "获取电站信息参数", required = true) @RequestBody CommonSelectOneInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = powerStationManagerService.getPowerStationInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取电站信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 删除指定电站信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "删除指定电站信息", tags="wushenjun", notes = "删除指定电站信息")
    @RequestMapping(value = "deletePowerStationInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut deletePowerStationInfo(HttpServletRequest request,
                                                  @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                  @ApiParam(value = "删除电站信息参数", required = true) @RequestBody CommonDeleteInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = powerStationManagerService.deletePowerStationInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "删除电站信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


}
