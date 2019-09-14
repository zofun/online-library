package com.web.onlineLibrary.service;

import com.web.onlineLibrary.base.entity.TableInfo;

public interface BookServer {

    TableInfo getBooKList(int page,int limit);
}
