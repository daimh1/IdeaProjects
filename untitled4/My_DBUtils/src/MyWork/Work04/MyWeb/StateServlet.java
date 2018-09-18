package MyWork.Work04.MyWeb;

import Utils.DBCPUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "StateServlet",urlPatterns = "/state")
public class StateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");


        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("exampleInputPassword1");
        System.out.println(username+password);
        response.setContentType("text/html; charset=utf-8");


        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        /*ArrayList<User> users= (ArrayList<User>) session.getAttribute("user");
        if(users==null){
            users=new ArrayList<>();
        }*/
        //如果session不为空，获取session
        if(session.getAttribute("username")!=null&&session.getAttribute("password")!=null) {
            username = (String) session.getAttribute("username");
            password = (String) session.getAttribute("password");
        }
        //System.out.println(sessionusername+" "+sessionpassword);

        session.setAttribute("username",username);
        session.setAttribute("password",password);

        /*User thisuser=new User();
        thisuser.setUsername(username);
        shoppingCart.add(productByProductId);
        session.setAttribute("shoppingCart",shoppingCart);*/
        if(isAdmin(username,password)){
            session.setAttribute("username","admin");
            session.setAttribute("password","1234");

            RequestDispatcher rd = request.getRequestDispatcher("/admin");
            rd.forward(request, response);

            return;
        }

        boolean flag=checkinfo(username,password);
        if(flag){


            response.getWriter().println("你已登录");
            response.getWriter().println("<a href=\"delete\">注销</a>");
        }else {
            response.getWriter().println("登录失败");
            session.setAttribute("username",null);
            session.setAttribute("password",null);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private boolean isAdmin(String username,String password){
        boolean flag=false;
        if(username.equals("admin")&&password.equals("1234")){
            flag=true;
        }

        return flag;
    }
    private boolean checkinfo(String username, String password) {
        Connection connection = DBCPUtils.getConnection();
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
                if (connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return flag;
    }
}
