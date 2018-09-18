import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Work05A",urlPatterns = "/ServletA")
public class Work05A extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /*
         * 在servlet中实现服务器端跳转，并向跳转页面传递参数
         */

        request.setAttribute("A", "A");
        ServletContext context=this.getServletContext();
        context.setAttribute("data","this is A");
        System.out.println("1");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ServletC");
        requestDispatcher.forward(request,response);
    }
}
