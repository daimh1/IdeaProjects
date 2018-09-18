package Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Work02",urlPatterns = "/work02")
public class Work02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //String username=null;
        //String password=null;
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
        //Cookie cookie1=new Cookie("username",username);
        //Cookie cookie2=new Cookie("password",password);
        response.getWriter().println("  <form action=\"/result\" method=\"post\">");
        response.getWriter().println("  用户名： <input type=\"text\" name=\"username\"  value  = '"+"'/><br>");
        response.getWriter().println(" 密码： <input type=\"password\" name=\"password\"  value  = '"+"' /><br>");
        response.getWriter().println("  自动登录 <input type=\"checkbox\" name=\"remember\" ><br>");
        response.getWriter().println("  <input type=\"submit\" name=\"登录\">");
        response.getWriter().println(" </form>");


        }
        else {
            //cookies[0]=new Cookie()
            request.getRequestDispatcher("/result").forward(request,response);
        }


    }
}
