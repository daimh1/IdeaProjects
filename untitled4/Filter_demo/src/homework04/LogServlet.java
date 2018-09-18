package homework04;

import Utils.DBCPUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LogServlet",urlPatterns = "/log")
public class LogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("exampleInputPassword1");
        HttpSession session=request.getSession();
        if(session.getAttribute("username")!=null&&session.getAttribute("password")!=null) {
            username = (String) session.getAttribute("username");
            password = (String) session.getAttribute("password");
        }
        //String age=request.getParameter("age");
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
            response.getWriter().println("<a href=\"Work04/delete.jsp\">注销</a>");
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
        boolean flag=false;
        SAXReader reader=new SAXReader();
        try {
            String string = ResServlet.class.getClassLoader().getResource(".").getPath();
            System.out.println(string);
            Document document=reader.read(string+"user.xml");
            Element root=document.getRootElement();
            List<Element> elements=root.elements();
            for(int i=0;i<elements.size();i++){
                if(elements.get(i).attribute("username").getValue().equals(password)&&elements.get(i).attribute("password").getValue().equals(password))
                flag=true;
                break;

            }


            /*OutputFormat format=OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");*/

        } catch (DocumentException e) {
            e.printStackTrace();
        }

       /* Connection connection = DBCPUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet =null;

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
        }*/


        return flag;
    }
}
