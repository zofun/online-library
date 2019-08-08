package com.web.onlineLibrary.service;

import com.web.onlineLibrary.domain.Permission;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;

import java.util.List;

/**
 * @author TCW
 */
public interface ShiroService {

    /**
     * 根据用户id获取角色信息
     * @return
     */
    Role getRoleByUserId(int id);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据角色id获取权限信息
     * @param id
     * @return
     */
    List<Permission> getPermissionsByRoleId(int id);
}
