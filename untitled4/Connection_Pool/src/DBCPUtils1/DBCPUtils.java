package DBCPUtils1;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DBCPUtils {


    //apache实现的连接池
    static  BasicDataSource dataSource;

    static {
        //new BasicDataSource();
         dataSource = new BasicDataSource();


        dataSource.setUrl("jdbc:mysql://127.0.0.1:8600/jdbc_0727?serverTimezone=GMT&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("2131415dmh");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        /*InputStream in = Pos.class.getClassLoader().
                getResourceAsStream("conn.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
            dataSource = factory.createDataSource(prop);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


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


    //释放资源
    public void releaseConnection(){


    }

}
