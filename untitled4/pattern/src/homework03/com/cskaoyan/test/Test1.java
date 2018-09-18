package homework03.com.cskaoyan.test;

import homework03.com.cskaoyan.utils.MyC3P0DataSouce;
import org.junit.Test;

import java.sql.SQLException;

public class Test1 {

    @Test
    public void test1(){
        try {
            if(MyC3P0DataSouce.getConnection()!=null){
                System.out.println("1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
