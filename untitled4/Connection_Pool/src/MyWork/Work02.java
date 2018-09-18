package MyWork;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import DBCPUtils1.MyDBConnPoolPro;
import org.junit.Test;

public class Work02 {
    @Test
    public void mytest(){

        Connection connection=MyDBConnPoolPro.getConntionFromPool();

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
}
