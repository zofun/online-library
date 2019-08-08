package com.web.onlineLibrary.service.Impl;

import com.web.onlineLibrary.dao.ShiroMapper;
import com.web.onlineLibrary.domain.Permission;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private ShiroMapper shiroMapper;

    @Override
    public Role getRoleByUserId(int id) {

        return shiroMapper.queryRoleByUserId(id);

    }

    @Override
    public User getUserByUsername(String username) {
        return shiroMapper.queryUserByUsername(username);
    }

    @Override
    public List<Permission> getPermissionsByRoleId(int id) {
        return shiroMapper.queryPermissionByRoleId(id);
    }
}
