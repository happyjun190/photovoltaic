package com.photovoltaic.web.appcontroller.auth;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.auth.IAuthService;
import com.photovoltaic.web.controller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.auth.LoginInModel;
import com.photovoltaic.web.model.in.auth.UpdateUserPwdInModel;
import com.photovoltaic.web.model.out.auth.LoginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wushenjun on 2017/4/15.
 */
@Api(tags = "App Auth")
@RestController
@RequestMapping("/app/auth/")
public class AppAuthController extends BaseController{

    @Autowired
    private IAuthService authService;

    /**
     * app用户登录
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "app端用户登录", tags="wushenjun", notes = "app(iOS、android)端用户登录，前端通过MD5将原始密码加密传给接口")
    @Permission(loginReqired=false)
    @RequestMapping(value = "login/{version}", method = RequestMethod.POST)
    public JsonResultOut<LoginDTO> login(HttpServletRequest request,
                                         @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                         @ApiParam(value = "登录所需信息", required = true) @RequestBody LoginInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.appLogin(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "用户登录失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * app端用户修改用户密码
     * @param request
     * @param version
     * @param inModel
     * @return
     */
    @ApiOperation(value = "app端用户修改用户密码", tags="wushenjun", notes = "app端用户修改用户密码")
    @Permission(loginReqired=false)
    @RequestMapping(value = "updateUserLoginPwd/{version}", method = RequestMethod.POST)
    public JsonResultOut updateUserLoginPwd(HttpServletRequest request,
                                         @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                         @ApiParam(value = "修改用户密码所需信息", required = true) @RequestBody UpdateUserPwdInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.updateUserLoginPwd(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "修改用户密码失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }




}
