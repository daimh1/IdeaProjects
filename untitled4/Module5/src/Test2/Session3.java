package Test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Session3",urlPatterns = "/session3")
public class Session3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Object username = session.getAttribute("username");

        String id = session.getId();

        System.out.println("id="+id);

        session.removeAttribute("username");  //删除域里的某个值

        System.out.println("username="+username);

        session.setAttribute("username","bbb");//修改某个值

        System.out.println("username="+username);
    }
}
