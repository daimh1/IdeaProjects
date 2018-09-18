    package homework02;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

    public class C3P0Utils {


        static ComboPooledDataSource cpds;

        static {
              cpds = new ComboPooledDataSource("mysql");


           /* try {
                cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
                cpds.setJdbcUrl( "jdbc:mysql://localhost:8600/jdbc_0727?serverTimezone=GMT" );
                cpds.setUser("root");
                cpds.setPassword("2131415dmh");
            }
            catch (PropertyVetoException e)
            {

                e.printStackTrace();
            }*/


        }

        //从C3P0连接池 获取连接
        public static Connection getConnection(){

            try {
                Connection connection = cpds.getConnection();
                return  connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return  null;
        }
        public static  DataSource getDataSource(){

            return  cpds;
        }



    }
