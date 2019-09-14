package com.web.onlineLibrary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.dao.BookMapper;
import com.web.onlineLibrary.domain.Book;
import com.web.onlineLibrary.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;


@Service
public class BookServerImpl implements BookServer {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public TableInfo getBooKList(int page, int limit) {
        int count=bookMapper.getCount();
        PageHelper.startPage(page,limit);
        List<Book> list = bookMapper.getBookList();


        return new TableInfo(0,"书籍推荐表",count,list.toArray());
    }
}
