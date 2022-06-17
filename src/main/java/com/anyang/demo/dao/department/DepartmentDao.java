package com.anyang.demo.dao.department;

import com.anyang.demo.dao.BaseDao;
import com.anyang.demo.domain.user.User;
import com.anyang.demo.view.department.DepartmentView;
import com.anyang.demo.view.user.UserView;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface DepartmentDao extends BaseDao<User> {

    DepartmentView selectViewById(Long id);

    DepartmentView selectViewByIdV2(Long id);

    DepartmentView selectViewByIdV3(Long id);
}