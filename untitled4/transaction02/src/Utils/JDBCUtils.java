package Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    private static ComboPooledDataSource dataSource;
    static {
        // 加载C3P0连接池
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
            dataSource.setJdbcUrl( "jdbc:mysql://127.0.0.1:8600/jdbc_0727?serverTimezone=GMT&useSSL=false" );
            dataSource.setUser("root");
            dataSource.setPassword("2131415dmh");
        }
        catch (PropertyVetoException e)
        {

            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
