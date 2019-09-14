package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BookMapper {

    @Select("select count(*) from recommend")
    int getCount();

    @Select("select * from recommend")
    List<Book> getBookList();
}
