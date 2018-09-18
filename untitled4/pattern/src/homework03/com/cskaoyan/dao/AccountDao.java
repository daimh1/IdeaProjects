package homework03.com.cskaoyan.dao;

import homework03.com.cskaoyan.bean.Account;

import java.sql.SQLException;

//给Dao设计API的时候，只care对于数据库的具体操作
//不考虑相关的业务逻辑
public interface AccountDao {

     boolean transferMoney(String from, String to, String money);


     //更新账户信息
     int updateAccount(Account account) throws SQLException;


     Account getAccountInfo(String id) throws SQLException;

}
