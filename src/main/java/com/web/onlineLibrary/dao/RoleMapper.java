package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.UserRoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper {


    @Select("select user.id,user.name,user.username,r.role_name\n" +
            "from user inner join role r on user.user_role = r.id")
    List<UserRoleInfo> queryUserRoleInfoList();
}
