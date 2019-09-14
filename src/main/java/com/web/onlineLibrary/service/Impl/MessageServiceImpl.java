package com.web.onlineLibrary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.dao.MessageMapper;
import com.web.onlineLibrary.domain.Message;
import com.web.onlineLibrary.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.LabelUI;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;


    @Override
    public TableInfo getMessageList(int page, int limit) {
        int count=messageMapper.getCount();
        PageHelper.startPage(page,limit);
        List<Message> list = messageMapper.getMessageList();
        TableInfo tableInfo = new TableInfo(0, "留言表", count, list.toArray());
        return tableInfo;
    }
}
