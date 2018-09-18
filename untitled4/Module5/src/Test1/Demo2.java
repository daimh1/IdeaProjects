package Test1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Demo2",urlPatterns = "/demo2")
public class Demo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                String name=cookie.getName();
                if("visitTime".equals(name)){
                    String value=cookie.getValue();
                    System.out.println("last visit time="+value);

                    response.getWriter().print("last visit time="+value);
                    String domain = cookie.getDomain();
                    String path = cookie.getPath();

                    System.out.println("domain:"+domain);//get不到
                    System.out.println("path:"+path);

                    return;
                }
            }
        }
        response.getWriter().print("你没访问过");
    }
}
