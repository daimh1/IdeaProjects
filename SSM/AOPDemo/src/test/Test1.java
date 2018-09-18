package test;

import bean.Account;
import factory.ServiceFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

import java.sql.SQLException;

public class Test1 {

    @Test
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
}
