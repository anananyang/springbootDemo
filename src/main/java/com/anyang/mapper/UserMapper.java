package com.anyang.mapper;

import com.anyang.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDO> getUsers();
}
