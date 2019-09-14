package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("getList")
    public TableInfo getList(int page,int limit){
        return roleService.getUserRoleList(page,limit);
    }
}
