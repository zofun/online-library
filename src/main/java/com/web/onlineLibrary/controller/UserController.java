package com.web.onlineLibrary.controller;


import com.web.onlineLibrary.base.entity.Result;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.UserService;
import com.web.onlineLibrary.utils.EncryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("register")
    public Result register(User user){
        if(!userService.register(user)){
            return new Result().fail("注册失败,用户名被占用",0);
        }
        return new Result().success("注册成功 ",1);
    }

    @RequestMapping("login")
    public Result login(User user, HttpSession session){

        return userService.login(user,session);

    }


    /**
     * 测试定时任务
     */
    @Scheduled(cron="0 */1 * * * ?")
    public void test01(){
        System.out.println("执行");
    }



}
