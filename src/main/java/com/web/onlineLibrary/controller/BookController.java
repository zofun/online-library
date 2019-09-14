package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.service.BookServer;
import com.web.onlineLibrary.service.Impl.BookServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookServer bookServer;

    @RequestMapping("getList")
    public TableInfo getList(int page,int limit){
        return bookServer.getBooKList(page,limit);
    }
}
