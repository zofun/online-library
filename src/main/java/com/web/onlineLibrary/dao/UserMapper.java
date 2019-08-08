package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id =#{id}")
    User queryById(@Param("id") Integer id);
}
