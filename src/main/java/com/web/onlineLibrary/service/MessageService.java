package com.web.onlineLibrary.service;

import com.web.onlineLibrary.base.entity.TableInfo;

public interface MessageService {

    TableInfo getMessageList(int page,int limit);
}
