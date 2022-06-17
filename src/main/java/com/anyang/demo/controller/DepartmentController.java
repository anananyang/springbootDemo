package com.anyang.demo.controller;

import com.anyang.demo.dao.department.DepartmentDao;
import com.anyang.demo.domain.base.Result;
import com.anyang.demo.view.department.DepartmentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("selectViewByIdV2")
    @ResponseBody
    public Result<?> selectViewByIdV2(Long departmentId) {
        if(departmentId == null) {
            return Result.wrapError("", "参数错误");
        }

        DepartmentView departmentView = departmentDao.selectViewByIdV2(departmentId);
        return Result.wrapSuccess(departmentView);
    }

    @RequestMapping("selectViewByIdV3")
    @ResponseBody
    public Result<?> selectViewByIdV3(Long departmentId) {
        if(departmentId == null) {
            return Result.wrapError("", "参数错误");
        }

        DepartmentView departmentView = departmentDao.selectViewByIdV3(departmentId);
        return Result.wrapSuccess(departmentView);
    }

}
