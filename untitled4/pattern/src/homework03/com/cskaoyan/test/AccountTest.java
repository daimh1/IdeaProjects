package homework03.com.cskaoyan.test;

import homework03.com.cskaoyan.bean.Account;
import homework03.com.cskaoyan.dao.AccountDao;
import homework03.com.cskaoyan.dao.impl.AccountDaoImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class AccountTest {


    @Test
    public void test1() throws SQLException {

        AccountDao dao = new AccountDaoImpl();

        Account account = new Account();
        account.setId("511310095");
        account.setMoney(1000);
        int i = dao.updateAccount(account);

        Assert.assertEquals(1,i);
    }

    @Test
    public void test2() throws SQLException {

        AccountDao dao = new AccountDaoImpl();

        Account accountInfo = dao.getAccountInfo("511310095");

        System.out.println("a="+accountInfo);

    }
}
