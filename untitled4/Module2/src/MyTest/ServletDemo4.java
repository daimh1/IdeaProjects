package MyTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@WebServlet(name = "ServletDemo4",urlPatterns = "/resp4")
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date=new Date(0);
        System.out.print(date.toString());
        long l=System.currentTimeMillis();
        response.setDateHeader("Expires",l+60*5*1000);
        int i=new Random().nextInt(10);
        response.getWriter().print("i="+i);
    }
}
