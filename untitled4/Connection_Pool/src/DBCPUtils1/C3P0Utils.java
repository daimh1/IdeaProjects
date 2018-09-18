package DBCPUtils1;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.sql.Connection;

public class C3P0Utils {
    static ComboPooledDataSource comboPooledDataSource;

    static {
        comboPooledDataSource=new ComboPooledDataSource("mysql");
        try {
            comboPooledDataSource.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
            comboPooledDataSource.setJdbcUrl( "jdbc:mysql://localhost:8600/jdbc_0727?serverTimezone=GMT" );
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("2131415dmh");
        }
        catch (PropertyVetoException e)
        {

            e.printStackTrace();
        }
    }
    public static Connection getConnection(){

        try {
            Connection connection = comboPooledDataSource.getConnection();
            return  connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return  null;
    }
}
