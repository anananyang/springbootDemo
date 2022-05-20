package com.anyang.demo.controller;

import com.anyang.demo.domain.base.Result;
import com.anyang.demo.exception.NoPermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String welcomePage(Model model) {
        model.addAttribute("myName", "anyang");
        return "index.html";
    }


    @RequestMapping(value = "/welcome", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result<?> welcome() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "你好");
        return Result.wrapSuccess(map);
    }

    /**
     * restful 风格需要增加
     *
     * @return
     */
    @RequestMapping(value = "/world", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> getWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "getWorld");
        return Result.wrapSuccess(map);
    }

    @RequestMapping(value = "/world", method = RequestMethod.POST)
    @ResponseBody
    public Result<?> addWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "addWorld");
        return Result.wrapSuccess(map);
    }

    @RequestMapping(value = "/world", method = RequestMethod.DELETE)
    @ResponseBody
    public Result<?> deleteWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "deleteWorld");
        return Result.wrapSuccess(map);
    }

    @RequestMapping(value = "/world", method = RequestMethod.PUT)
    @ResponseBody
    public Result<?> updateWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "updateWorld");
        return Result.wrapSuccess(map);
    }

    /**
     * 抛出异常
     *
     * @return
     */
    @RequestMapping(value = "/exceptionTest")
    @ResponseBody
    public Result<?> excceptionTest(HttpServletResponse response) {
        System.out.println("excceptionTest");
        // by zero
        if (5 / 0 == 0) {
            // do nothing
        }

        return Result.wrapSuccess(null);
    }


    /**
     * 抛出异常
     *
     * @return
     */
    @RequestMapping(value = "/myExceptionTest")
    @ResponseBody
    public Result<?> myExcceptionTest() throws NoPermissionException {
        throw new NoPermissionException();
    }


}
