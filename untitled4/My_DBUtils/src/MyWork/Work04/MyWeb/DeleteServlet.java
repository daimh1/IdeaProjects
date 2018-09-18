package MyWork.Work04.MyWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        session.setAttribute("username",null);
        session.setAttribute("password",null);

        response.getWriter().println("您已注销！即将跳转到首页");
        String href=request.getContextPath()+"/login.html";
        System.out.println(href);
        href=response.encodeURL(href);
        System.out.println(href);
        response.setHeader("refresh","3;url="+href);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
