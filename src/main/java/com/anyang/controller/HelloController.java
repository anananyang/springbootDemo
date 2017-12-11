package com.anyang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.anyang.mapper.UserMapper;
import com.anyang.model.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.MapUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/welcome", method = {RequestMethod.GET, RequestMethod.POST})
    public String welcome (HttpServletRequest requestm, HttpServletResponse response) {
        logger.info("{}","开始运行");
        String welcome = "welcome";
        logger.info("{}","结束运行");
        return welcome;
    }

    @RequestMapping(value = "/testFastJson", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String testFastJson(HttpServletRequest request, HttpServletResponse response) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("hello");
        jsonArray.add("world");
        return jsonArray.toJSONString();
    }

    @RequestMapping(value = "/getAllUser", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<UserDO> users = userMapper.getUsers();
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("data",users);
        return JSON.toJSONString(map);
    }




}
