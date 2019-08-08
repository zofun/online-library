package com.web.onlineLibrary.shiro;

import com.web.onlineLibrary.domain.Permission;
import com.web.onlineLibrary.domain.Role;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    /**
     * 授权逻辑
     * @param pc
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        //获得user对象
        User user = (User) pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user != null) {
            Role role = shiroService.getRoleByUserId(user.getId());
            if(role!=null){
                //添加角色角色信息
                info.addRole(role.getRoleName());
                return info;
            }
            List<Permission> permissionsByUser = shiroService.getPermissionsByRoleId(role.getId());
            if (permissionsByUser.size() != 0) {
                for (Permission p : permissionsByUser) {
                    //添加权限信息
                    info.addStringPermission(p.getPower());
                }
                return info;
            }
        }
        return  null;

    }

    /**
     * 认证逻辑
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获得用户输入的用户名,这个对象就是login()传递过来的，将它强转以取出封装的用户名
        UsernamePasswordToken usernameToken = (UsernamePasswordToken) token;
        String userName = usernameToken.getUsername();

        User user = shiroService.getUserByUsername(userName);

        if (user == null){
            //用户不存在，返回null
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");


    }
}
