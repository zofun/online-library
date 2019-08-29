package com.web.onlineLibrary.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.onlineLibrary.base.entity.TableInfo;
import com.web.onlineLibrary.dao.ContentMapper;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentDetail;
import com.web.onlineLibrary.domain.ContentInfo;
import com.web.onlineLibrary.service.ContentService;
import com.web.onlineLibrary.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


/**
 * @author TCW
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public boolean addContent(Content content) {
        if(contentMapper.insert(content)==1){
            return  true;
        }
        return  false;
    }

    @Override
    public TableInfo getContentInfoList(int page, int limit, String title, String author, String time) throws ParseException {

        Date date=null;
        if(time!=null){
            date=DateUtils.toDate(time);
        }
        PageHelper.startPage(page,limit);
        //对紧跟着的一页进行分页
        List<ContentInfo> list = contentMapper.query(title, author, date);
        //获取数据总数
        PageInfo<ContentInfo> pageInfo=new PageInfo<ContentInfo>(list);
        long total = pageInfo.getTotal();

        return new TableInfo(0,"内容列表",(int)total,list.toArray());
    }

    @Override
    public void changeTitle(int id, String title) {
        contentMapper.updateTitle(id,title);
    }

    @Override
    public void delContent(int id) {
        contentMapper.deleteContent(id);
    }

    @Override
    public ContentDetail getContentDetailById(Integer id) throws UnsupportedEncodingException {
        ContentDetail detail = contentMapper.queryContentDetailById(id);
        //解决乱码
        detail.setMarkdown(new String(detail.getMarkdown().getBytes("iso8859-1"),"utf-8"));
        return  detail;
    }
}
