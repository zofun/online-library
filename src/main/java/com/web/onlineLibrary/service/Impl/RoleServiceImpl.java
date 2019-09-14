package com.web.onlineLibrary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.dao.RoleMapper;
import com.web.onlineLibrary.dao.UserMapper;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.UserRoleInfo;
import com.web.onlineLibrary.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;



    @Override
    public TableInfo getUserRoleList(int page, int limit) {
        int count=userMapper.queryUserCount();

        PageHelper.startPage(page,limit);
        List<UserRoleInfo> list=roleMapper.queryUserRoleInfoList();

        return new TableInfo(0,"用户角色列表",count,list.toArray());
    }
}
