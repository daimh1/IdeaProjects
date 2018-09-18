package Test1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Demo1",urlPatterns = "/demo1")
public class Demo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date=new Date();
        Cookie cookie=new Cookie("visitTime",date.toString());

        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        response.getWriter().print("visited 1st!");
    }
}
