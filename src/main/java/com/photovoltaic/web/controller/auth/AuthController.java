package com.photovoltaic.web.controller.auth;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.auth.IAuthService;
import com.photovoltaic.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ziye on 2017/4/15.
 */
@RestController
@RequestMapping("/servlet/auth/")
public class AuthController extends BaseController{

    @Autowired
    private IAuthService authService;

    /**
     * 用户注册
     *
     * @param map
     * @return
     */
    @Permission(loginReqired=false)
    @RequestMapping(value = "/regist/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult regist(HttpServletRequest request,
                               @RequestBody Map<String, Object> map,
                               @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.regist(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "用户注册失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * web用户登录
     *
     * @param map
     * @return
     */
    @Permission(loginReqired=false)
    @RequestMapping(value = "/webLogin/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult webLogin(HttpServletRequest request,
                      @RequestBody Map<String, Object> map,
                      @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = authService.webLogin(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "用户登录失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }

}
