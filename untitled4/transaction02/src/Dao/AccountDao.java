package Dao;

import Utils.JDBCUtils;
import bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.sql.Connection;

public class AccountDao {
    public Account findAccountById(int id) throws SQLException {
        String sql = "select * from account where id = ?";
        Object[] params = {id};
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return queryRunner.query(sql, new BeanHandler<Account>(Account.class), params);
    }

    // 更新账户: 接受传递的连接
    public void update(Account account, Connection conn) throws SQLException {
        String sql = "update account set name = ?, money = ? where id = ?";
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(conn, sql, params);
    }
}
