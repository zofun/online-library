package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface ContentMapper {

    @Insert("insert into content (title,author,markdown,recommend,classify) " +
            "values (#{title},#{author},#{markdown},#{recommend},#{classify})")
    int insert(Content content);


    List<ContentInfo> query(String title, String author, Date time);
}
