package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentDetail;
import com.web.onlineLibrary.domain.ContentInfo;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface ContentMapper {

    /**
     * 插入新的内容
     * @param content
     * @return
     */
    @Insert("insert into content (title,author,markdown,recommend,classify,time) " +
            "values (#{title},#{author},#{markdown},#{recommend},#{classify},now())")
    int insert(Content content);


    /**
     * 根据条件查询内容
     * @param title
     * @param author
     * @param time
     * @return
     */
    @Select("<script>" +
            "select c.id,c.title,c.time,u.username as 'author',c2.name as 'classify' from content as c inner join user u on c.author = u.id inner join category c2 on c.classify = c2.id"+
                "<where>"+
                    "<if test='title != null'>"+
                        "and c.title like concat('%',#{title},'%')"+
                    "</if>"+
                    "<if test='author != null'>"+
                        "and u.username like concat('%',#{author},'%')"+
                    "</if>"+
                    "<if test='time != null'>"+
                        "and c.time=STR_TO_DATE(#{time},'%Y-%m-%d')"+
                    "</if>"+
                "</where>"+
            "</script>")
    List<ContentInfo> query(@Param("title") String title, @Param("author") String author,@Param("time") Date time);

    /**
     * 更新标题
     * @param id
     * @param title
     */
    @Update("update content set title=#{title} where id=#{id}")
    void updateTitle(@Param("id") int id,@Param("title") String title);

    /**
     * 删除指定的内容
     * @param id
     */
    @Delete("delete from content where id=#{id}")
    void deleteContent(@Param("id") int id);

    /**
     * 根据id查询内容的详细信息
     * @param id
     * @return
     */
    @Select("select  content.id,content.title,content.markdown,content.recommend,c.name as 'classify',u.name as 'author',c.id as 'classifyCode' from content " +
            "inner join category c on content.classify = c.id inner join user u on content.author = u.id " +
            "where content.id=#{id}")
    ContentDetail queryContentDetailById(@Param("id") int id);
}
