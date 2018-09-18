package homework03.com.cskaoyan.proxy;

import homework03.com.cskaoyan.bean.Account;

import java.sql.SQLException;

public class TransferTest {
    public static void main(String[] args) throws SQLException {
        Account out = new Account();
        out.setId("1");

        Account in = new Account();
        in.setId("2");

        AccountService accountService = new AccountServiceImpl();

        // 获取accountService代理
        AccountService accountServiceProxy = (AccountService) TransactionProxy.proxy(accountService);
        accountServiceProxy.transfer(out, in, 100);
    }
}
