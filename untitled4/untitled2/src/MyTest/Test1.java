package MyTest;

import Connection.MyConnection;
import Utils.DBUtils;
import Utils.MyDBConnPool;
import Utils.MyDBConnPoolPro;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

    @Test
    public void mytest(){

       Connection connection=MyDBConnPool.getConntionFromPool();

        System.out.println(connection);

    }

    @Test
    public void mytest2(){
        DataSource poolPro=new MyDBConnPoolPro();
        Connection connection=null;

        try {
            connection=poolPro.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        System.out.println(connection);

    }
    /*public void test4(){
        Connection connection=DBUtils.getConnection();
        MyConnection myConnection=new MyConnection(connection);

        try {
            Statement statement=myConnection.createStatement();
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
}
