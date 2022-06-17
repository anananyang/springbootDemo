package com.anyang.demo.dao.user;

import com.anyang.demo.dao.BaseDao;
import com.anyang.demo.domain.user.User;
import com.anyang.demo.view.user.UserView;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao extends BaseDao<User> {

    User selectByUserNameAndMobile(@Param("userName") String name,
                                   @Param("mobile") String mobile);

    @MapKey("id")
    Map<Long, Object> selectAllUser();

    UserView selectViewById(Long userId);

    UserView selectViewByIdV2(Long userId);

    List<UserView> selectByDeptId(Long deptId);

}