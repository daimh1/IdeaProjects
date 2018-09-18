package Mytest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Demo1",urlPatterns = "/demo1")
public class Demo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastAccessTime=null;

        Cookie[] cookies=request.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            System.out.println(cookies[i].getName());
            if("lastAccess".equals(cookies[i].getName())){
                lastAccessTime=cookies[i].getValue();
                break;
            }
        }
        if(lastAccessTime==null){
            response.getWriter().print("您是首次访问");
        }else{
            response.getWriter().print("您上次访问的时间是："+lastAccessTime);
        }

        String currenttime=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
        Cookie cookie=new Cookie("lastAccess",currenttime);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
