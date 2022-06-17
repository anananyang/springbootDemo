package com.anyang.demo.view.department;

import com.anyang.demo.view.user.UserView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties("handler")
@Data
public class DepartmentView {
    private Long id;
    private String name;
    // 部门中的成员
    private List<UserView> employees;
}
