package MyWeb;

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

@WebServlet(name = "StateServlet",urlPatterns = "/state")
public class StateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("exampleInputPassword1");
        System.out.println(username+password);
        response.setContentType("text/html; charset=utf-8");
        boolean flag=checkinfo(username,password);
        if(flag){
            response.getWriter().println("你已登录");
            response.getWriter().println("<a href=\"login.html\">注销</a>");
        }else {
            response.getWriter().println("登录失败");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private boolean checkinfo(String username, String password) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        boolean flag=false;
        if(connection!=null){
            try {
                String sql="SELECT * FROM user WHERE username = ? AND password = ?";
                statement=connection.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                System.out.println(sql);
                resultSet=statement.executeQuery();
                while(resultSet.next())  //游标指向下一行;
                {
                    flag=true;
                    break;
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtils.realse(resultSet,statement,connection);
            }
        }


        return flag;
    }
}
