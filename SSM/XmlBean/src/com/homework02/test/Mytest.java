package com.homework02.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    @Test
    public void test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        Object user=applicationContext.getBean("user");//id唯一，name
        System.out.println("user="+user);
    }
}
