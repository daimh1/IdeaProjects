package Servlet;

import Utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean ret= login(username, password);

        if (ret){

            response.getWriter().println("登录成功！");
        }else
        {
            response.getWriter().println("用户名密码不对！");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private boolean login(String username, String password) {

        Connection connection = DBUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        boolean ret =false;

        if (connection!=null){

            try {

                String sql = "SELECT * FROM t_user WHERE name = '"+username+"' AND password = "+password;

                statement = connection.prepareStatement(sql);

                /*statement.setString(1,username);
                statement.setString(2,password);*/

                System.out.println("sql="+sql);
                resultSet = statement.executeQuery();


                while(resultSet.next())  //游标指向下一行;
                {
                    ret=true;
                    break;
                }

            }

            catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtils.realse(resultSet,statement,connection);
            }


        }


        return ret;



    }

}
