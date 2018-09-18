package com.filter;

import com.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/userServlet")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)req;

        HttpSession session = httpRequest.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("exampleInputPassword1");
        try{
        if(username.equals("admin")&&password.equals("1234")){
            session.setAttribute("regAdmin","abc");
            session.setAttribute("session_user",new User("admin","1234","0"));
            session.setAttribute("session_username","admin");
        req.getRequestDispatcher("/userServlet?op=getInfo").forward(req, resp);
            return;
        }}catch (NullPointerException e){

        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
