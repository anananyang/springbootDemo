package com.anyang.demo.controller;

import com.anyang.demo.dao.user.UserDao;
import com.anyang.demo.domain.base.Result;
import com.anyang.demo.domain.user.User;
import com.anyang.demo.view.user.UserView;
import com.anyang.service.HelloService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "greet")
    @ResponseBody
    public Result<?> greet(String userName) {
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
        user.setDefaultBiz(1l);
        userDao.insert(user);
        return Result.wrapSuccess(null);
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> getById(Long userId) {
        User user = userDao.selectById(userId);
        return Result.wrapSuccess(user);
    }


    @RequestMapping(value = "selectByUserNameAndMobile", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> selectByUserNameAndMobile(String userName, String mobile) {
        User user = userDao.selectByUserNameAndMobile(userName, mobile);
        return Result.wrapSuccess(user);
    }

    @RequestMapping(value = "selectAllUser", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> selectAllUser() {
        Map<Long, Object> map = userDao.selectAllUser();
        return Result.wrapSuccess(map);
    }

    @RequestMapping(value = "selectViewById", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> selectViewById(Long userId) {
        if(userId == null) {
            return Result.wrapError("", "参数错误");
        }
        UserView userView = userDao.selectViewById(userId);
        return Result.wrapSuccess(userView);
    }


    @RequestMapping(value = "selectViewByIdV2", method = RequestMethod.GET)
    @ResponseBody
    public Result<?> selectViewByIdV2(Long userId) {
        if(userId == null) {
            return Result.wrapError("", "参数错误");
        }
        UserView userView = userDao.selectViewByIdV2(userId);
        userView.getDepartment();
        return Result.wrapSuccess(userView);
    }


}

