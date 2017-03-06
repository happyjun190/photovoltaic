package com.photovoltaic.web.controller.test;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.test.ITestService;
import com.photovoltaic.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wushenjun on 2017/3/6.
 * 测试controller
 */
@Controller
@RequestMapping("/servlet/test")
public class TestController extends BaseController {
    @Autowired
    private ITestService testService;

    /**
     * 1、获取测试数据列表
     * @param request
     * @param map
     * @return
     */
    @Permission(loginReqired = false)
    @RequestMapping(value = "/getTestDataList", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult getTestDataList(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        JsonResult jsonResult = null;
        try {
            jsonResult = testService.getTestDataList(map);
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "返回购物车列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }

}
