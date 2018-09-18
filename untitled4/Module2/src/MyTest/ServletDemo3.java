package MyTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo3",urlPatterns = "/resp3")
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object key=request.getAttribute("key");
        System.out.printf("key");

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if("123".equals(username)&&"456".equals(password)){
            response.setHeader("refresh","3;url=/index.html");//重定向
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("即将跳转");
        }
    }
}
