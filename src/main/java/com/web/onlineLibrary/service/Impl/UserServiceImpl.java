package com.web.onlineLibrary.service.Impl;

import com.web.onlineLibrary.base.entity.Result;
import com.web.onlineLibrary.dao.UserMapper;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.domain.UserInfo;
import com.web.onlineLibrary.service.ShiroService;
import com.web.onlineLibrary.service.UserService;
import com.web.onlineLibrary.utils.EncryptUtils;
import org.apache.ibatis.lang.UsesJava7;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShiroService shiroService;

    @Override
    public User queryUser(int id) {
        return userMapper.queryById(id);

    }

    @Override
    public boolean register(User user) {

        if(userMapper.queryUsernameCountById(user.getUsername())>0){
            //用户名已经被注册
            return false;
        }
        //对密码进行加盐hash加密
        String[] result = EncryptUtils.encryptPassword(user.getPassword());
        user.setPassword(result[0]);
        user.setSalt(result[1]);
        //设置为普通用户角色
        user.setUserRole(1);
        userMapper.insert(user);
        return true;
    }

    @Override
    public Result login(User user , HttpSession session) {

        String salt= userMapper.querySaltByUsername(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        String ciphertext=EncryptUtils.getInputPasswordCiph(user.getPassword(),salt);
        user.setPassword(ciphertext);
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            User u=(User)subject.getPrincipal();
            //将用户信息存入session
            session.setAttribute("User",u);
            Role role = shiroService.getRoleByUserId(u.getId());
            UserInfo userInfo=new UserInfo(u.getName(),u.getUsername(),role.getRoleName(),role.getRoleMsg());
            return  new Result().success("登录成功",1,userInfo);
        }catch (UnknownAccountException e){

            return  new Result().success("账号不存在",0);
        }catch (IncorrectCredentialsException e){

            return  new Result().success("账号或密码错误",0);
        }
    }
}
