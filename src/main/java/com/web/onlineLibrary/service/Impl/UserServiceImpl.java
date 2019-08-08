package com.web.onlineLibrary.service.Impl;

import com.web.onlineLibrary.dao.UserMapper;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(int id) {
        return userMapper.queryById(id);

    }
}
