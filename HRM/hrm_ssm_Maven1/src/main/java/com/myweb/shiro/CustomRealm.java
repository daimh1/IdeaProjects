package com.myweb.shiro;

import com.myweb.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import java.util.Date;

public class CustomRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "CustomRealm";
    }

    //认证的时候，需要我们去调用自己的realm，返回用户认证的信息，从数据库里返回
    //这里只是返回当前用户的认证信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        Object principal = authenticationToken.getPrincipal();
        System.out.println("principal="+principal);


        //去数据库里查询用户名叫张三的用户信息
        String password_getfrom_db = "123";

        User user = new User();
        user.setUsername("aaa");
        user.setLoginname("bbb");
        user.setPassword(password_getfrom_db);
        user.setStatus(1);
        user.setCreateDate(new Date());


          //参数一也就是身份信息，会被放入到Session域里。

        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                user,
                password_getfrom_db,
                getName()
        );


        return simpleAuthenticationInfo;
    }




    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //根据用户信息去查询该用户的授权信息，
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        System.out.println("primaryPrincipal="+primaryPrincipal);

        //授权信息
        SimpleAuthorizationInfo authorizationInfo =new SimpleAuthorizationInfo();

         authorizationInfo.addRole("role1");
         //authorizationInfo.addRoles();
         authorizationInfo.addStringPermission("user:insert");
        authorizationInfo.addStringPermission("user:delete");
        authorizationInfo.addStringPermission("user:add");


        return authorizationInfo;
    }


}
