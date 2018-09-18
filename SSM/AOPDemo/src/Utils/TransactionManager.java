package Utils;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
    private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

    static {
        local.set(JDBCUtils.getConnection());
    }
    // 开启事务
    public static void beginTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    // 回滚事务
    public static void rollback() throws SQLException {
        Connection conn = local.get();
        if (conn != null) {
            conn.rollback();
            conn.close();
            // 清空threadLocal
            local.remove();
        }
    }

    // 提交事务
    public static void commit() throws SQLException {
        Connection conn = local.get();
        if (conn != null) {
            conn.commit();
            // 清空threadLocal
            local.remove();
        }
    }

    // 关闭连接
    public static void close() throws SQLException {
        Connection conn = local.get();
        if (conn != null) {
            conn.close();
            // 清空threadLocal
            local.remove();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() {
        return local.get();
    }

}
