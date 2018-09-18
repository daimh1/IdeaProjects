package Homework;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "Work03A",urlPatterns = "/Work03ServletA")
public class Work03A extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user=new User();
        Map<String, String[]> parameterMap = request.getParameterMap();

        try {
            BeanUtils.populate(user,parameterMap);
            System.out.println("user xx="+user);
            /*if(user.getUsername().equals("123")&&user.getPassword().equals("456")){

            }*/
            ServletContext context=this.getServletContext();
            context.setAttribute("data",user);
            RequestDispatcher rd = request.getRequestDispatcher("/Work03ServletB");
            rd.forward(request, response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

