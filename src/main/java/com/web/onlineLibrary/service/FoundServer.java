package com.web.onlineLibrary.service;

import com.web.onlineLibrary.base.entity.TableInfo;

public interface FoundServer {

    /**
     * 分页获取失物品招领的列表
     * @param page 页数
     * @param limit 每页的数量
     * @return
     */
    TableInfo getFoundList(int page,int limit);
}
