package com.web.onlineLibrary.dao;


import com.web.onlineLibrary.domain.Permission;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ShiroMapper {

    @Select("select * from user where id=#{id}")
    User queryUserById(@Param("id") int id);

    @Select("select * from user where username=#{username}")
    User queryUserByUsername(@Param("username") String username);

    @Select("select * from permission where role_id=#{roleId}")
    List<Permission> queryPermissionByRoleId(@Param("roleId") int roleId);

    @Select("select r.* from user as u inner join role as r where u.user_role=r.id and u.id=#{userId}")
    Role queryRoleByUserId(@Param("userId") int userId);
}
