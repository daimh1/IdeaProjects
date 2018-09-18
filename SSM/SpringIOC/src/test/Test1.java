package test;

import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.impl.UserServiceImpl;

public class Test1 {

    //么有使用spring的case
    @Test
    public void test1(){
        UserService userService=new UserServiceImpl();
        boolean wangdao=userService.login("wangdao","123");
        System.out.println("wangdao :"+wangdao);
    }

    @Test
    public void test2(){
        UserServiceImpl userService=new UserServiceImpl();

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao daoimpl = (UserDao) applicationContext.getBean("daoimpl");

        userService.setDao(daoimpl);

        boolean wangdao=userService.login("wangdao","123");
        System.out.println("wangdao :"+wangdao);
    }

    @Test
    public void test3(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        UserServiceImpl servcieImpl = (UserServiceImpl) applicationContext.getBean("servcieImpl");

        //这一行service依赖的dao的注入：依赖注入 这是我们手动的注入
        //servcieImpl.setDao(daoimpl);

        //要使用spring进行自动注入


        boolean wangdao = servcieImpl.login("wangdao",  "123");

        System.out.println("login="+wangdao);

    }

    @Test
    public void test4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Object daoiml2=applicationContext.getBean("daoImpl2");
    }
}
