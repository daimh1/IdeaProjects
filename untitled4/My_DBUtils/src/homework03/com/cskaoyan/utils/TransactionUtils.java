package homework03.com.cskaoyan.utils;

import Utils.C3P0Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtils {


    static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        threadLocal.set(DBUtils.getConnection());
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
