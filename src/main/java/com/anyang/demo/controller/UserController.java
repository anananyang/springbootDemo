package com.anyang.demo.controller;

import com.anyang.demo.domain.base.Result;
import com.anyang.demo.domain.user.User;
import com.anyang.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "greet")
    @ResponseBody
    public Result<?> greet(String userName){
        String greet = helloService.hello(userName);
        return Result.wrapSuccess(greet);
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    @ResponseBody
//    public Result<?> addUser(@Validated User user) {
//        return Result.wrapSuccess(user);
//    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Result<?> addUserByRequestBody(@RequestBody User user) {
        return Result.wrapSuccess(user);
    }

}

