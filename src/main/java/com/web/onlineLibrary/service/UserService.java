package com.web.onlineLibrary.service;

import com.web.onlineLibrary.base.entity.Result;
import com.web.onlineLibrary.domain.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    User queryUser(int id);

    /**
     * 用户注册，注册成功返回true，否则返回false
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    Result login(User user, HttpSession session);
}
