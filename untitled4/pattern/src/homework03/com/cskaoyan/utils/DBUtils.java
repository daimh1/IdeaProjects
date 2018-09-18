package homework03.com.cskaoyan.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {


    private static String driver;
    private static String sqlusername;
    private static String passwrod;
    private static String url;

    static {


        //根据类加载的路径，去找类加载同级根目录下的资源文件
        //URL resource = DBUtils.class.getClassLoader().getResource("com/conn.properties");
           /* String file = resource.getFile();
            System.out.println("file="+file);*/
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("conn.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            driver = properties.getProperty("driver");
            sqlusername = properties.getProperty("username");
            passwrod = properties.getProperty("password");
            url = properties.getProperty("url");

            Class.forName( driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    /**
     *
     * @return  可能会返回null，当连接失败的时候
     */
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url,sqlusername,passwrod);
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
