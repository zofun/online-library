package com.web.onlineLibrary.service;

import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentDetail;
import com.web.onlineLibrary.domain.ContentInfo;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

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

    /**
     * 根据条件获取内容列表
     * @param page
     * @param limit
     * @param title
     * @param author
     * @param time
     * @return
     */
    TableInfo getContentInfoList(int page, int limit, String title, String author, String time) throws ParseException;


    /**
     * 修改指定id的内容的标题
     * @param id
     * @param title
     */
    void changeTitle(int id,String title);

    /**
     * 删除指定id的内容
     * @param id
     */
    void delContent(int id);

    /**
     * 根据id获取内容的详细信息
     * @param id
     * @return
     */
    ContentDetail getContentDetailById(Integer id) throws UnsupportedEncodingException;
}
