package com.photovoltaic.web.controller.test;

import com.photovoltaic.annotation.Permission;
import com.photovoltaic.commons.constants.ReturnCode;
import com.photovoltaic.commons.json.JsonResult;
import com.photovoltaic.service.test.ITestService;
import com.photovoltaic.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/getTestDataList/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult getTestDataList(HttpServletRequest request,
                               @RequestBody Map<String, Object> map,
                               @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = testService.getTestDataList(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "返回购物车列表失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 2、新增测试数据
     * @param request
     * @param map
     * @return
     */
    @Permission(loginReqired = false)
    @RequestMapping(value = "/insertTest/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult insertTest(HttpServletRequest request,
                          @RequestBody Map<String, Object> map,
                          @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = testService.insertTest(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "新增测试数据失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }



    /**
     * 3、更新测试数据
     * @param request
     * @param map
     * @return
     */
    @Permission(loginReqired = false)
    @RequestMapping(value = "/updateTest/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult updateTest(HttpServletRequest request,
                          @RequestBody Map<String, Object> map,
                          @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = testService.updateTest(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "更新测试数据失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }


    /**
     * 4、删除测试数据
     * @param request
     * @param map
     * @return
     */
    @Permission(loginReqired = false)
    @RequestMapping(value = "/deleteTest/{version}", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult deleteTest(HttpServletRequest request,
                          @RequestBody Map<String, Object> map,
                          @PathVariable("version") String version) {
        JsonResult jsonResult;
        try {
            switch (version) {
                case "v100":
                    jsonResult = testService.deleteTest(map);
                    break;
                default:
                    jsonResult = new JsonResult(ReturnCode.PARAMSERROR, "无效的URL版本号！");
                    break;
            }
        } catch (Exception e) {
            jsonResult = new JsonResult(ReturnCode.EXCEPTION, "删除测试数据失败！", null);
            logger.error(e.getMessage(),e);
        }
        return jsonResult;
    }

}
