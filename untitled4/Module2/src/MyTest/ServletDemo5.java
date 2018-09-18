package MyTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo5",urlPatterns = "/resp5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("key","hello!");
        /*response.setStatus(404);
        response.getWriter().print("NOT FOUND");*///自定义404

        /*response.setStatus(301);
        response.setHeader("location","index.html");*///重定位1

        //response.sendRedirect("/index.html");//重定位2
        response.getWriter().print("hello!");

        response.getWriter().flush();
        response.sendRedirect("/index.html");
    }
}
