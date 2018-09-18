package MyTest;

import Bean.MyUser;
import Utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ResultSetHandlerTest {

    @Test
    public void test1() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(C3P0Utils.getDataSource());

        Object[] query=queryRunner.query("select * from t_user",new ArrayHandler());//arrayHander把第一行数据转为对象数组
        for (Object obj:query){
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){


        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            List<Object[]> query = queryRunner.query("select * from t_user", new ArrayListHandler());

            for (Object[] obj: query) {

                for (Object o: obj) {
                    System.out.print("\tvalue="+o);
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test3(){


        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            MyUser query = queryRunner.query("select * from t_user", new BeanHandler<MyUser>(MyUser.class));

            System.out.println("user=" +query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test4(){


        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            List<MyUser> query = queryRunner.query("select * from t_user", new BeanListHandler<MyUser>(MyUser.class));

            System.out.println("user=" +query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test5(){


        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            List<Object>  usernames = queryRunner.query("select username from t_user", new ColumnListHandler());;

            System.out.println("user=" +usernames);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test6(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            Map<Object, Map<String, Object>> values = queryRunner.query("select * from t_user",
                    new KeyedHandler());

            System.out.println("user=" +values);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test7(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            Map<String, Object> query = queryRunner.query("select * from t_user", new MapHandler());

            System.out.println("user=" +query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test8(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            List<Map<String, Object>> query = queryRunner.query("select * from t_user", new MapListHandler());

            System.out.println("user=" +query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test9(){

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            Object  query = queryRunner.query("select count(*) from t_user", new ScalarHandler());

            System.out.println("object=" +query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
