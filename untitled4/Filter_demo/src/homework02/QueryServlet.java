package homework02;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryServlet",urlPatterns = "/query")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        try {
            List<User> query = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));

            System.out.println("user=" +query);
//            HttpSession session=request.getSession();
//            session.setAttribute("users",query);
            request.setAttribute("users",query);
            RequestDispatcher rd = request.getRequestDispatcher("/homework02.jsp");
            rd.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
