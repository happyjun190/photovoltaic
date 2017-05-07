package com.photovoltaic.web.admincontroller.devicemanager;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.service.devicemanager.IInverterDeviceManagerService;
import com.photovoltaic.web.admincontroller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.devicemanager.InverterInfoAddInModel;
import com.photovoltaic.web.model.in.devicemanager.InverterSelectOneInModel;
import com.photovoltaic.web.model.out.inveter.InverterInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wushenjun on 2017/5/7.
 * 逆变器设备管理controller
 */
@Api(tags = "Admin Inverter Manager")
@RestController
@RequestMapping("/admin/invertermanager/")
public class InverterDeviceManagerController extends BaseController{
    @Autowired
    private IInverterDeviceManagerService inverterDeviceManagerService;

    /**
     * 获取逆变器列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "分页获取逆变器列表，可供查询", tags="wushenjun", notes = "分页获取逆变器列表，可供查询(逆变器名查询)")
    @RequestMapping(value = "getInverterDeviceList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<InverterInfoDTO>> getInverterDeviceList(HttpServletRequest request,
                                                                      @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                      @ApiParam(value = "分页查询逆变器列表参数", required = true) @RequestBody CommonQueryInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = inverterDeviceManagerService.getInverterDeviceList(inModel);
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
     * 新增或更新逆变器信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "新增或更新逆变器信息", tags="wushenjun", notes = "新增或更新逆变器信息")
    @RequestMapping(value = "insertOrUpdateInverterInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut insertOrUpdateInverterInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "注册所需信息", required = true) @RequestBody InverterInfoAddInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = inverterDeviceManagerService.insertOrUpdateInverterInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "新增或更新逆变器信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取指定逆变器信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取指定逆变器信息", tags="wushenjun", notes = "获取指定逆变器信息")
    @RequestMapping(value = "getInverterInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut getInverterInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "获取逆变器信息参数", required = true) @RequestBody InverterSelectOneInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = inverterDeviceManagerService.getInverterInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取逆变器信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }



}
