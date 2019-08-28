package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.Result;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author TCW
 * 内容管理相关
 */
@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("add")
    public Result add(Content content, HttpSession session){
        User user=(User)session.getAttribute("User");
        content.setAuthor(user.getId());
        if(contentService.addContent(content)){
            return new Result().success();
        }
        return new Result().fail(0,"发布失败");
    }


    @RequestMapping("get-content-list")
    public TableInfo get(int page, int limit,
                         @RequestParam(required = false) String title,@RequestParam(required = false) String author,@RequestParam(required = false) String time){

        return new TableInfo();
    }
}
