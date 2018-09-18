package homework03;

import Utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/Work03/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();
            if (session.getAttribute("username").equals("admin") && session.getAttribute("password").equals("1234")) {

                QueryRunner queryRunner = new QueryRunner(DBCPUtils.getDataSource());
                try {
                    List<User> query = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));

                    session.setAttribute("queryResult",query);
                    RequestDispatcher rd = request.getRequestDispatcher("/Work03/admin.jsp");
                    rd.forward(request, response);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //不管是空指针还是session错误，都不能进入admin页面
            } else {
                //out.println("登录失败");
                RequestDispatcher rd = request.getRequestDispatcher("/Work03/login.html");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("/Work03/login.html");
            rd.forward(request, response);
            //out.println("登录失败");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
