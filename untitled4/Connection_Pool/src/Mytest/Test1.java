package Mytest;

import DBCPUtils1.DBCPUtils;
import DBCPUtils1.DBUtils;
import org.testng.annotations.Test;

import java.sql.*;

public class Test1 {

    @Test
    public void mytest(){

        Connection connection=DBUtils.getConnection();

        System.out.println("conn  "+connection);

    }

    @Test
    public void test2(){
        Connection connection=DBCPUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void MyTest1()  {


        Connection connection = DBCPUtils.getConnection();

        System.out.println("conn="+connection);

        try {

            //列名和表名 不能去做占位符的参数  ：此路不通
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  * from acco");

            //preparedStatement.setString(1,"allen");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                float aFloat = resultSet.getFloat(1);

                System.out.println("money="+aFloat);
            }

            /*Statement statement = connection.createStatement();

            statement.executeUpdate("DELETE FROM account WHERE NAME ='allen'");*/

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
