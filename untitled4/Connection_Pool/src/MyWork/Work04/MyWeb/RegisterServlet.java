package MyWork.Work04.MyWeb;

import DBCPUtils1.DBCPUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("exampleInputPassword1");
        String age=request.getParameter("age");
        System.out.println(username+password+age);

        //把数据写入数据库
        insert(username,password,age);

        //重定向
        RequestDispatcher rd = request.getRequestDispatcher("/login.html");
        rd.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void insert(String username, String password, String age) {
        Connection connection = DBCPUtils.getConnection();
        PreparedStatement preparedStatement=null;

        if(connection!=null){
            try {
                String sql = "insert into user values (?,?,?)";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.setInt(3, Integer.parseInt(age));

                preparedStatement.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }finally {
                {
                    if (connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                }
            }
        }
    }
}
