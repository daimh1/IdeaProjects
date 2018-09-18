package Homework;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "Work05",urlPatterns = "/Work05Servlet")
public class Work05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username;

        res.setContentType("text/html; charset=utf-8");

        username = req.getParameter("username");

        synchronized (this) {
            PrintWriter output = res.getWriter();

            try {
                Thread.sleep(10000); //为了突出并发问题，在这设置一个延时


                output.println("用户名:" + username + "<br>");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//使用上同步锁的方式解决线程安全问题
}
