package com.web.onlineLibrary.controller;

import com.web.onlineLibrary.base.entity.Result;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentDetail;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.ContentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

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
        if(user==null){
            return new Result().fail("请登录",500);
        }
        content.setAuthor(user.getId());
        if(contentService.addContent(content)){
            return new Result().success();
        }
        return new Result().fail(0,"发布失败");
    }


    /**
     * 获取内容列表
     * @param page
     * @param limit
     * @param title
     * @param author
     * @param time
     * @return
     */
    @RequestMapping("get-content-list")
    public TableInfo get(int page, int limit,
                         @RequestParam(required = false) String title,@RequestParam(required = false) String author,@RequestParam(required = false) String time) throws ParseException {

        return contentService.getContentInfoList(page,limit,title,author,time);
    }


    /**
     * 更改标题
     * @param id
     * @param title
     * @return
     */
    @RequestMapping("change-title")
    public Result changeTitle(Integer id,String title){
        contentService.changeTitle(id,title);
        return new Result().success();
    }

    /**
     * 删除内容
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public Result del(@PathVariable(value = "id") Integer id){
        contentService.delContent(id);
        return new Result().success();
    }

    @RequestMapping("get/{id}")
    public Result get(@PathVariable(value = "id") Integer id) throws UnsupportedEncodingException {
        ContentDetail detail = contentService.getContentDetailById(id);
        return new Result().success(detail);
    }
}
