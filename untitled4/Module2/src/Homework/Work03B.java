package Homework;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Work03B",urlPatterns = "/Work03ServletB")
public class Work03B extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ServletContext context=this.getServletContext();
        User user=(User)context.getAttribute("data");
        response.setContentType("text/html; charset=utf-8");
        if(user.getUsername().equals("123")&&user.getPassword().equals("456")){
            response.getWriter().print("账号密码正确");
        }else{
            response.getWriter().print("账号或密码错误");
        }
    }
}
