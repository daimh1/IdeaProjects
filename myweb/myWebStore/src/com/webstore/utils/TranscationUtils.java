package com.webstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TranscationUtils {
    static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        threadLocal.set(DBCPUtils.getConnection());
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
}
