package com.web.onlineLibrary.service;

import com.web.onlineLibrary.domain.Permission;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroServiceTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShiroService shiroService;

    @Test
    public void getRoleByUserId() {
        logger.info("测试");
        Role role=shiroService.getRoleByUserId(1);
        System.out.println(role.toString());
    }

    @Test
    public void getUserByUsername() {

        User user =shiroService.getUserByUsername("123456");
        System.out.println(user.toString());
    }

    @Test
    public void getPermissionsByRoleId() {

        List<Permission> permissions = shiroService.getPermissionsByRoleId(1);
        for (Permission p:permissions){
            System.out.println(p.toString());
        }
    }
}