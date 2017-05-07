package com.photovoltaic.web.admincontroller.usermanager;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.service.user.IUserManagerService;
import com.photovoltaic.web.admincontroller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.user.UserInfoAddInModel;
import com.photovoltaic.web.model.in.user.UserInfoQueryInModel;
import com.photovoltaic.web.model.out.auth.LoginDTO;
import com.photovoltaic.web.model.out.user.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wushenjun on 2017/5/4 0004.
 * 用户管理controller
 */
@Api(tags = "Admin User Manage")
@RestController
@RequestMapping("/admin/usermanager/")
public class UserManagerController extends BaseController {


    @Autowired
    private IUserManagerService userManagerService;

    /**
     * 获取用户列表
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "分页获取用户列表，可供查询", tags="wushenjun", notes = "分页获取用户列表，可供查询(用户登录名、中文名查询)")
    @RequestMapping(value = "/getUserInfoList/{version}", method = RequestMethod.POST)
    public JsonResultOut<List<UserInfoDTO>> getUserInfoList(HttpServletRequest request,
                                                            @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                            @ApiParam(value = "注册所需信息", required = true) @RequestBody UserInfoQueryInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = userManagerService.getUserInfoList(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "获取用户列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 新增/更新用户信息
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "新增/更新用户信息", tags="wushenjun", notes = "新增/更新用户信息")
    @RequestMapping(value = "/insertOrUpdateUserInfo/{version}", method = RequestMethod.POST)
    public JsonResultOut<LoginDTO> insertOrUpdateUserInfo(HttpServletRequest request,
                                                   @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                                   @ApiParam(value = "新增/更新用户所需信息", required = true) @RequestBody UserInfoAddInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = userManagerService.insertOrUpdateUserInfo(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "新增/更新用户信息失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }

}
