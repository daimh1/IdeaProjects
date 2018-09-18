package MyTest;

import Bean.MyUser;
import Utils.C3P0Utils;
import Utils.DBCPUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @org.junit.Test
    public void test1() {

        try {
        Connection connection = C3P0Utils.getConnection();
        System.out.println(connection);

        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user");
            ResultSet resultSet=preparedStatement.executeQuery();
            ArrayList<MyUser> users=new ArrayList<>();

            while (resultSet.next()){
                String id=resultSet.getString("id");
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");
                String email=resultSet.getString("email");
                String birthday=resultSet.getString("birthday");
                String headerPath=resultSet.getString("headerPath");

                MyUser user=new MyUser(id,username,password,email,birthday,headerPath);

                users.add(user);
            }
            connection.close();
            System.out.println(users);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){

        Connection connection=C3P0Utils.getConnection();
        try {

            QueryRunner queryRunner = new QueryRunner();
            ArrayList<MyUser> users = queryRunner.query(connection, "select * from t_user;", new ResultSetHandler<ArrayList<MyUser>>() {
                @Override
                public ArrayList<MyUser> handle(ResultSet resultSet) throws SQLException {
                    ArrayList<MyUser> users = new ArrayList<>();

                    while (resultSet.next()) {

                        String id = resultSet.getString("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        String email = resultSet.getString("email");
                        String birthday = resultSet.getString("birthday");
                        String headerPath = resultSet.getString("headerPath");

                        MyUser user = new MyUser(id, username, password, email, birthday, headerPath);
                        users.add(user);
                    }
                    //System.out.println(users);
                    return users;
                }
            });
            System.out.println(users);
        }catch (SQLException e){
            e.printStackTrace();
        }
        }
        @Test
        public void test3(){
            try {
                Connection connection=C3P0Utils.getConnection();
                QueryRunner queryRunner=new QueryRunner();
                List<MyUser> list=queryRunner.query(connection,"select * from t_user;",new BeanListHandler<MyUser>(MyUser.class));
                System.out.println(list);
                DbUtils.close(connection);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    @Test
    public void test4() {

        try {

            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

            List<MyUser> list = queryRunner.query("select * from t_user where username like  ?;",
                    new BeanListHandler<MyUser>(MyUser.class), "%a%");

            System.out.println("userlist=" + list);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test5() {

        try {

            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());


            int update = queryRunner.update("insert into t_user values(null,'zhangsan','123','zs@qq.com','1990-01-01','')");

            System.out.println("ret=" + update);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test6() {

        try {

            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

            int update = queryRunner.update("insert into t_user values(null,?,?,?,?,?);", "lisi", "123",
                    "zs@qq.com", "1990-01-01", "");


            System.out.println("ret=" + update);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void test9(){
        try {
            QueryRunner queryRunner=new QueryRunner(C3P0Utils.getDataSource());
            Object[][] params = new Object[3][];
            for(int i=0;i<params.length;i++){
                params[i]=new Object[]{6+i};
            }
            int[] batch=queryRunner.batch("insert into t_user values(null,'zhangsan','123','zs@qq.com','1990-01-01',?)",params);
            for (int i : batch) {
                System.out.println("i=" + i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test10() {

        try {

            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());


            List<MyUser> users = new ArrayList<MyUser>();
            for (int i = 0; i < 10; i++) {
                users.add(new MyUser(null,"wangdao" + i, "pass" + i, "qq" + i, "1995-1-" + i, null));
            }

            //批量把user插入到表中
            Object[][] params = new Object[users.size()][];

            for (int i = 0; i < 10; i++) {

                params[i] = new Object[]{users.get(i).getUsername(),
                        users.get(i).getPassword(),
                        users.get(i).getEmail(),
                        users.get(i).getBirthday(),
                        users.get(i).getHeaderPath()};
            }


            int[] batch = queryRunner.batch("insert into t_user values (null, ?,?,?,?,?)", params);

            for (int i : batch) {
                System.out.println("i=" + i);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}