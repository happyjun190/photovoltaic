package com.photovoltaic.web.admincontroller.devicemanager;

import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.service.devicemanager.IDtuDeviceManagerService;
import com.photovoltaic.web.admincontroller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.CommonDeleteInModel;
import com.photovoltaic.web.model.in.CommonQueryInModel;
import com.photovoltaic.web.model.in.CommonSelectOneInModel;
import com.photovoltaic.web.model.in.devicemanager.DtuDeviceInfoAddInModel;
import com.photovoltaic.web.model.in.devicemanager.InverterInfoAddInModel;
import com.photovoltaic.web.model.out.devicemanager.DtuDeviceInfoDTO;
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
 * dtu设备管理controller
 */
@Api(tags = "Admin Dtu Manager")
@RestController
@RequestMapping("/admin/dtumanager/")
public class DtuDeviceManagerController extends BaseController{
    @Autowired
    private IDtuDeviceManagerService dtuDeviceManagerService;

    /**
     * 获取dtu设备列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "分页获取dtu设备列表，可供查询", tags="wushenjun", notes = "分页获取dtu设备列表，可供查询")
    @RequestMapping(value = "getDtuDeviceList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<DtuDeviceInfoDTO>> getDtuDeviceList(HttpServletRequest request,
                                                                  @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                                  @ApiParam(value = "分页查询dtu设备列表参数", required = true) @RequestBody CommonQueryInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = dtuDeviceManagerService.getDtuDeviceList(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取dtu设备列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 新增或更新dtu设备信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "新增或更新dtu设备信息", tags="wushenjun", notes = "新增或更新dtu设备信息")
    @RequestMapping(value = "insertOrUpdateDtuDeviceInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut insertOrUpdateDtuDeviceInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "新增或更新dtu设备所需信息", required = true) @RequestBody DtuDeviceInfoAddInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = dtuDeviceManagerService.insertOrUpdateDtuDeviceInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "新增或更新dtu设备信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 获取指定dtu设备信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "获取指定dtu设备信息", tags="wushenjun", notes = "获取指定dtu设备信息")
    @RequestMapping(value = "getDtuDeviceInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut<DtuDeviceInfoDTO> getDtuDeviceInfo(HttpServletRequest request,
                                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                    @ApiParam(value = "获取dtu设备信息参数", required = true) @RequestBody CommonSelectOneInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = dtuDeviceManagerService.getDtuDeviceInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取dtu设备信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }




    /**
     * 删除指定dtu设备信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "删除指定dtu设备信息", tags="wushenjun", notes = "删除指定dtu设备信息")
    @RequestMapping(value = "deleteDtuDeviceInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut deleteDtuDeviceInfo(HttpServletRequest request,
                                                            @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                            @ApiParam(value = "删除dtu设备参数", required = true) @RequestBody CommonDeleteInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = dtuDeviceManagerService.deleteDtuDeviceInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "删除dtu设备信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }




}
