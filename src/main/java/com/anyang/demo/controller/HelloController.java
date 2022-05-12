package com.anyang.demo.controller;

import com.anyang.demo.domain.base.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "/welcome", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result<?> welcome () {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "你好");
        return Result.wrapSuccess(map);
    }
}
