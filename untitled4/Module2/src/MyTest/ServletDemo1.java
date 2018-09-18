package MyTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo1",urlPatterns = "/resp1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("text/html; charset=utf-8");//方法一
        //response.getWriter().println("hello!王道");

        //response.setHeader("Content-Type","text/html; charset=utf-8");//方法二
        //response.getWriter().println("你好");

        response.setCharacterEncoding("utf-8");
        response.getWriter().print("<header><meta charset=\"utf-8\"></header>");
        response.getWriter().print("你好");

    }
}
