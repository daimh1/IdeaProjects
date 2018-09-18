package test;

import bean.Account;
import service.AccountService;

import java.sql.SQLException;

public class TransferTest {

    public static void main(String[] args) throws SQLException {

        Account out = new Account();
        out.setId(1);

        Account in = new Account();
        in.setId(2);
        AccountService accountService = new AccountService();
        accountService.transfer(out, in, 100);
    }
}
