package homework03;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/Work03/state.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*HttpServletRequest httpRequest = (HttpServletRequest)req;

        HttpSession session = httpRequest.getSession();
        //System.out.println(session.getAttribute("username").toString()+session.getAttribute("password").toString());
        if(session.getAttribute("username")==null||session.getAttribute("password")==null){
            if(req.getParameter("username")==null||req.getParameter("password")==null) {

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Work03/login.html");
                requestDispatcher.forward(req, resp);
                return;
            }
        }
*/

        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
