package DBCPUtils1;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCPUtils {

    static DataSource dataSource;

    static {
        dataSource = new BasicDataSource();
    }


    public static Connection getConnection(){
        Connection connection=null;

        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
