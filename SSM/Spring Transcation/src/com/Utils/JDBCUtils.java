package com.Utils;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    static BasicDataSource dataSource;

    static {
        //new BasicDataSource();
        dataSource = new BasicDataSource();


        dataSource.setUrl("jdbc:mysql://127.0.0.1:8600/jdbc_0727?serverTimezone=GMT&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("2131415dmh");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");


    }


    //从DBCP连接池里去取
    public static Connection getConnection(){

        Connection connection =null;
        try {
            connection= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  connection;

    }
    public static DataSource getDataSource(){

        return  dataSource;
    }

    //释放资源
    public void releaseConnection(){


    }
}
