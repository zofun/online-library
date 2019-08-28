package com.web.onlineLibrary.service;

import com.web.onlineLibrary.domain.Content;

/**
 * @author TCW
 * 内容管理服务
 */
public interface ContentService {

    /**
     * 添加新的内容
     * @param content
     */
    boolean addContent(Content content);
}
