/*
package com.photovoltaic.web.controller.auth;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.auth.IAuthService;
import com.photovoltaic.web.controller.BaseController;
import com.photovoltaic.web.model.JsonResultOut;
import com.photovoltaic.web.model.in.auth.LoginInModel;
import com.photovoltaic.web.model.in.auth.RegistInModel;
import com.photovoltaic.web.model.out.auth.LoginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

*/
/**
 * Created by ziye on 2017/4/15.
 *//*

@Api(tags = "Web Auth")
@RestController
@RequestMapping("/servlet/auth/")
public class AuthController extends BaseController{

    @Autowired
    private IAuthService authService;

    */
/**
     * 用户注册
     * @param request
     * @param version
     * @param inModel
     * @return
     *//*

    @ApiOperation(value = "用户注册", tags="wushenjun", notes = "用于注册用户，账号密码配置，前端通过base64将原始密码加密传给接口")
    @Permission(loginReqired=false)
    @RequestMapping(value = "/regist/{version}", method = RequestMethod.POST)
    public JsonResultOut<LoginDTO> regist(HttpServletRequest request,
                                          @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                          @ApiParam(value = "注册所需信息", required = true) @RequestBody RegistInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.regist(inModel);
                    break;
                default:
                    jsonResult = new JsonResultOut(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResultOut(ReturnCode.EXCEPTION, "用户注册失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    */
/**
     * web用户登录
     * @param request
     * @param version
     * @param inModel
     * @return
     *//*

    @ApiOperation(value = "web端用户登录", tags="wushenjun", notes = "web端用户登录，前端通过MD5将原始密码加密传给接口")
    @Permission(loginReqired=false)
    @RequestMapping(value = "/webLogin/{version}", method = RequestMethod.POST)
    public JsonResultOut<LoginDTO> webLogin(HttpServletRequest request,
                                    @ApiParam(value = "版本号：v100", required = true) @PathVariable String version,
                                    @ApiParam(value = "登录所需信息", required = true) @RequestBody LoginInModel inModel) {
        JsonResultOut jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.webLogin(inModel);
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

}
*/
