package MyTest;
import Utils.DBCPUtils;

import java.sql.Connection;

import static org.junit.Assert.*;

public class MyDBUtilsTest {

    @org.junit.Test
    public void getConnection(){
        Connection connection=DBCPUtils.getConnection();
        System.out.println(connection);
    }
}
