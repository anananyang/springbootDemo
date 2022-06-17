package com.anyang.demo.view.user;

import com.anyang.demo.domain.department.Department;
import com.anyang.demo.view.department.DepartmentView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

// 忽略 mybatis 延迟加载的 handler
@JsonIgnoreProperties(value = "handler")
@Data
public class UserView {
    private Long id;
    private String name;
    private String nickName;
    private String mobile;
    private String sex;
    private Integer age;
    private Long deptId;
    // 所属部门
    private DepartmentView department;
}
