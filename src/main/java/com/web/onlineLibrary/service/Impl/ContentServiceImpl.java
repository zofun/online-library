package com.web.onlineLibrary.service.Impl;

import com.web.onlineLibrary.dao.ContentMapper;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
