import Utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
//作业三
@WebServlet(name = "TransServlet",urlPatterns = "/transfer")
public class TransServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String sql="select * from student;";

        try {
            transfer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    public static boolean transfer() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag=false;
        Savepoint savepoint_transfer_Ok =null;

        ResultSet resultSet = null;
        try {


        conn = DBUtils.getConnection();
        conn.setAutoCommit(false);



        String sql_add="update acco set money= money+ ? where aid = ?";
        preparedStatement= conn.prepareStatement(sql_add);
        int a=5000;
        preparedStatement.setInt(1,a);
        preparedStatement.setInt(2,2);
        int ret2 = preparedStatement.executeUpdate();
        System.out.println("ret2="+ret2);
            savepoint_transfer_Ok = conn.setSavepoint();


            String sql_sub="update acco set money = money-? where aid = ?";
            preparedStatement = conn.prepareStatement(sql_sub);
            preparedStatement.setInt(1,a*ret2);
            preparedStatement.setInt(2,1);
            int ret1=preparedStatement.executeUpdate();
            System.out.println(ret1);
            savepoint_transfer_Ok = conn.setSavepoint();

            /*String sql_sub3="update acco set money = money+? where aid = ?";
            preparedStatement = conn.prepareStatement(sql_sub3);
            preparedStatement.setInt(1,1000);
            preparedStatement.setInt(2,1);
            int ret3=preparedStatement.executeUpdate();
            System.out.println(ret3);
            savepoint_transfer_Ok = conn.setSavepoint();*/




        conn.commit();

        flag=true;}
        catch (IndexOutOfBoundsException e){

            //这个时候
            if (conn!=null&&savepoint_transfer_Ok!=null){
                try {
                    conn.rollback(savepoint_transfer_Ok);  //
                    //回滚到某些回滚点，这些回滚点之前数据库的写操作，如需要生效，则必须手动提交。
                    conn.commit();

                    flag=true;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();

            //当发生异常的时候，就回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }


        finally {
            DBUtils.realse(null,preparedStatement,conn);
        }
        //DBUtils.realse(resultSet, preparedStatement, conn);
        return flag;
    }
}
