package com.test;

import com.factory.ServiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.service.AccountService;

import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    AccountService service;

    @Test
    public void test5(){
        service.transfer(2,1,100);
    }

    /*@Test
    public void test1() throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService =ServiceFactory.getAccountService();
        accountService.transfer(2, 1, 100);
    }

    @Test
    public void test2() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService servcie = (AccountService) applicationContext.getBean("servcieProxy");

        servcie.transfer(1,2,100);
    }

    @Test
    public void test3(){
        AccountService service=ServiceFactory.getAccountService2();
        service.transfer(1,2,100);
    }

    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService servcie = (AccountService) applicationContext.getBean("service");
        servcie.transfer(1,2,100);
    }*/


}
