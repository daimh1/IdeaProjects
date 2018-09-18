package com.webstore.test;

import com.webstore.bean.User;
import com.webstore.dao.UserDao;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class UserTest {

    @Test
    public void test1(){
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        //System.out.println(timeStamp);
        User user=new User(null,"lisi","lisi123","123","ls@163.com",timeStamp.toString(),timeStamp.toString());
        System.out.println(UserDao.saveUser(user));
    }

    @Test
    public void test2(){
        System.out.println(UserDao.findAllUser());
    }

    @Test
    public void test3(){
        Date date=new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(timeStamp.toString());
        System.out.println(UserDao.UpdateUser("1","wangwu","ww","1234","ww@qq.com",timeStamp.toString(),timeStamp.toString()));
    }

    @Test
    public void test4(){
        System.out.println(UserDao.deleteUserById("2"));
    }

    @Test
    public void test5(){
        System.out.println(UserDao.findUserByNameAndPassword("wangwu","1234"));
    }
}
