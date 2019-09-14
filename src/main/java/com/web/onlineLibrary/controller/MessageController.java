package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("getList")
    public TableInfo getList(int page,int limit){
        return messageService.getMessageList(page,limit);
    }
}
