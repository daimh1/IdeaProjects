package homework03.com.cskaoyan.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtils {


    static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        try {
            threadLocal.set(MyC3P0DataSouce.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

      return   threadLocal.get();
    }


    public static void beganTransaction() throws SQLException {

        getConnection().setAutoCommit(false);
    }


    public static void commit() throws SQLException {

        getConnection().commit();

    }

    public static void rollback() throws SQLException {

        getConnection().rollback();
    }
    public static void close() throws SQLException {
        getConnection().close();
    }

}
