package com.test;

import com.bean.User;
import com.model.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class XmlTest {

    @org.junit.Test
    public void testSaveUser(){
        User user=new User(null,"张三","123","10");
        boolean b=UserModel.saveUser(user);
        System.out.println(b);
        Assert.assertEquals(true,b);
    }

    @Test
    public void testLogin(){


        User user= new User(null,"张三","123","10");

        boolean userByUseranmeAndPassword = UserModel.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        Assert.assertTrue(userByUseranmeAndPassword);

    }

    @Test
    public void testFindUserBYUsername(){


        User user= new User(null,"张三","123","aaa");


        User userByUserName = UserModel.findUserByUserName(user.getUsername());

        Assert.assertNotNull(userByUserName);

    }

}
