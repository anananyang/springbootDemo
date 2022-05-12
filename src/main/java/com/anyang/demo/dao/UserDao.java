package com.anyang.demo.dao;

import com.anyang.demo.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectById(Long id);
}
