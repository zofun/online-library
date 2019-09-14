package com.web.onlineLibrary.dao;

import com.web.onlineLibrary.domain.Found;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface FoundMapper {

    @Select("select count(*) from found")
    int getCount();

    @Select("select * from found")
    List<Found> getFoundList();
}
