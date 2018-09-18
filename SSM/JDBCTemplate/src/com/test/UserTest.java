package com.test;


import com.bean.User;
import com.dao.UserDaoImpl;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//这个测试用例归spring的容器管
@RunWith(SpringJUnit4ClassRunner.class)
//告诉spring 的核心配置文件的名字和位置
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {


    @Autowired
    UserService service;

   // UserDaoImpl dao=new UserDaoImpl();

   /* @Test
    public void test(){


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userserivce = (UserService) context.getBean("userserivce");

        User userById = userserivce.findUserById("2024");

        System.out.println("user="+userById);


    }*/

    @Test
    public void test(){


        User userById = service.findUserById("2");

        System.out.println("user="+userById);


    }

    @Test
    public void test1(){
        User user=new User(null,"xiaod","123","11@qq.com");

        System.out.println(service.add(user));
    }

    @Test
    public void test2(){
        System.out.println(service.delete("100"));
    }

    @Test
    public void test3(){
        System.out.println(service.update("19",new User(null,"1","1","1")));
    }
}
