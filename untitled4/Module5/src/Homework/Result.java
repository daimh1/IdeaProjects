package Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Result",urlPatterns = "/result")
public class Result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Cookie cookie1=new Cookie("username",null);
        Cookie cookie2=new Cookie("password",null);
        cookie1.setMaxAge(600);
        cookie2.setMaxAge(600);
        if(username!=null&&password!=null) {
            cookie1.setValue(username);
            cookie2.setValue(password);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }
        response.getWriter().print("你已登录");

        /*Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName()+":"+cookie.getValue());

        }*/
    }
}
