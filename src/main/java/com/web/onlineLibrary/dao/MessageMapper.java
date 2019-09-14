package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {

    @Select("select count(*) from message")
    int getCount();


    @Select("select u.name as commentatorName,m.id,m.info,m.replier,m.reply,m.time  " +
            "from message as m inner join user as u\n" +
            "on u.id=m.commentator_id")
    List<Message> getMessageList();

}
