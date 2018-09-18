package Test1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Demo4",urlPatterns = "/demo4")
public class Demo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies){
                String name=cookie.getName();
                if("visitTime".equals(name)){
                    String value=cookie.getValue();
                    System.out.println("last visit time="+value);

                    cookie.setPath("/aaa");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    response.getWriter().print("cookie"+name+"deleted");
                    return;
                }
            }
        }
    }
}
