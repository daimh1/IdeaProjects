package Utils;


import JDBC.Work02;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static String driver;
    private static String sqlusername;
    private static String sqlpassword;
    private static String url;

    static {
        URL resource = Work02.class.getClassLoader().getResource("conn.properties");
        InputStream inputStream= Work02.class.getClassLoader().getResourceAsStream("conn.properties");
        Properties properties=new Properties();

        try {
            properties.load(inputStream);
            driver=properties.getProperty("driver");
            sqlusername=properties.getProperty("username");
            sqlpassword=properties.getProperty("password");
            url=properties.getProperty("url");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,sqlusername,sqlpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void realse(ResultSet resultSet, Statement st, Connection conn) {

        try {
            if (resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (st!=null){
                st.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
