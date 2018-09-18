package MyWork.Work04.MyWeb;

import Utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //引入前端框架
        response.getWriter().println("<link href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "    <script src=\"https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
                "    <script src=\"https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n" +
                "    <script src=\"https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js\"></script>");
        HttpSession session=request.getSession();
        /*ArrayList<User> users= (ArrayList<User>) session.getAttribute("user");
        if(users==null){
            users=new ArrayList<>();
        }*/try {


        if(session.getAttribute("username").equals("admin")&&session.getAttribute("password").equals("1234")) {

            resAdmin(response);
        //不管是空指针还是session错误，都不能进入admin页面
        }else {
            response.getWriter().println("登录失败");
        }}catch (Exception e){
            response.getWriter().println("登录失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void resAdmin(HttpServletResponse response) throws IOException {
        QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
        try {
            List<Map<String, Object>> query = queryRunner.query("select * from user", new MapListHandler());
            response.getWriter().println("<table class=\"table table-bordered table-striped\">");
            response.getWriter().println("<tr></tr><td><h1>用户列表</h1></td></tr>");
            response.getWriter().println("<tr> <td>username</td> <td>password</td><td>age</td><td>function</td></tr>");
            for (Map<String, Object> q : query) {
                response.getWriter().println("<tr>");

                //为了保证用户名-密码-年龄顺序一致，遍历三次map，每次取出一个元素
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("username")) {
                        response.getWriter().println("<td>" + entry.getValue().toString() + "</td>");
                    }
                }
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("password"))
                        response.getWriter().println("<td>" + entry.getValue().toString() + "</td>");
                }
                for (Map.Entry<String, Object> entry : q.entrySet()) {
                    if (entry.getKey().equals("age"))
                        response.getWriter().println("<td>" + entry.getValue().toString() + "</td>");
                }
                response.getWriter().println("<td>" + "<a href=\"delete\">删除</a>" + "</td>");
                response.getWriter().println("</tr>");
            }
            response.getWriter().println("<tr> <td><input type=\"text\" name=\"username\"></td> <td><input type=\"text\" name=\"password\"></td><td><input type=\"text\" name=\"age\"></td><td><a href=\"/admin\">提交</a></td></tr>");
            response.getWriter().println("</table>");
            response.getWriter().println("<a href=\"delete\">注销</a>");//注销重新把session置为空
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
