package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.User;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("select * from user where id =#{id}")
    User queryById(@Param("id") Integer id);

    @Select("select count(*) from user where username=#{username}")
    int queryUsernameCountById(@Param("username") String username);

    @Insert("insert into user (name,username,password,salt,user_role) values (#{name},#{username},#{password},#{salt},#{userRole})")
    void insert(User user);

    @Select("select salt from user where username=#{username}")
    String querySaltByUsername(@Param("username") String username);
}
