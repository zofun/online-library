package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.service.FoundServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Found")
public class FoundController {

    @Autowired
    private FoundServer foundServer;

    /**
     * 获取失物招领列表
     * @param page 页码
     * @param limit 每个页面的最大数据条数
     * @return
     */
    @RequestMapping("getList")
    public TableInfo getList(int page,int limit){
        return foundServer.getFoundList(page,limit);
    }
}
