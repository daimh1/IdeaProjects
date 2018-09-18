package Test1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "Demo3",urlPatterns = "/aaa/demo3")
public class Demo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().setAttribute("3rd","aaa");
        getServletContext().setAttribute("1st",new Object());

        Cookie cookie=new Cookie("3rd",UUID.randomUUID().toString());

        cookie.setValue("23233432");

        cookie.setMaxAge(60*60);
        cookie.setPath("/aaa");//设置什么样的路径才能获得cookie

        response.addCookie(cookie);

        response.getWriter().print("visited 3st!");
    }
}
