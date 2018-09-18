package Utils;

import Utils.DBUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;
import Connection.MyConnection;

public class MyDBConnPoolPro implements DataSource {

    static LinkedList<MyConnection> pool ;


    static {

        pool  = new LinkedList<MyConnection>();

        //初始化10个连接
        for (int i = 0; i < 10; i++) {
            Connection connection = DBUtils.getConnection();
            MyConnection myConnection=new MyConnection(connection,pool);
           // Connection myConnection = new Connection(connection,pool);

            pool.add(myConnection);
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        if (pool.size()>0){

            return pool.removeFirst();

        }

        return  null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
