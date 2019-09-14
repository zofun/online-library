package com.web.onlineLibrary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.dao.FoundMapper;
import com.web.onlineLibrary.domain.Found;
import com.web.onlineLibrary.service.FoundServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FounudServerImpl implements FoundServer {

    @Autowired
    private FoundMapper foundMapper;

    @Override
    public TableInfo getFoundList(int page, int limit) {

        int count=foundMapper.getCount();
        PageHelper.startPage(page,limit);
        List<Found> list = foundMapper.getFoundList();
        TableInfo info = new TableInfo(0,"失物招领列表",count,list.toArray());
        info.setData(list.toArray());
        return info;
    }
}
