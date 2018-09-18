package test;

import bean.Account;
import proxy.TransactionProxy;
import service.AccountService;
import service.AccountServiceImpl;

import java.sql.SQLException;

public class TransferTest {

    public static void main(String[] args) throws SQLException {

        Account out = new Account();
        out.setId(1);

        Account in = new Account();
        in.setId(2);
        AccountService accountService = new AccountServiceImpl();

        // 获取accountService代理
        AccountService accountServiceProxy = (AccountService) TransactionProxy.proxyFor(accountService);
        accountServiceProxy.transfer(out, in, 100);
    }
}
