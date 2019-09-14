package com.web.onlineLibrary.service;


import com.web.onlineLibrary.base.entity.TableInfo;

public interface RoleService {

    TableInfo getUserRoleList(int page,int limit);
}
