package com.web.onlineLibrary.controller;


import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public String getUser(Integer id){
         User user=userService.queryUser(id);
         return user.toString();
    }


    @RequestMapping("login")
    public String login(User user){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            System.out.println("登录成功");
            return  "登录成功";
        }catch (UnknownAccountException e){
            System.out.println("账号不存在");
            return "该账号不存在";
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            return "账号或密码错误";
        }

    }

    @Scheduled(cron="0 */1 * * * ?")
    public void test(){
        System.out.println("执行");
    }
}
