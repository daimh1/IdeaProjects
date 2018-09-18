package homework03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

public class Test {
    @org.junit.Test
    public void test2(){
        try {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService servcie = (AccountService) applicationContext.getBean("servcieProxy");

            servcie.transfer(1,2,100);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
