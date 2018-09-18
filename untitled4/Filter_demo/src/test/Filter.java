package test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter",urlPatterns = "/mytest")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //要修改或检查请求对象
        resp.getWriter().println("filter");
        //对请求放行
        chain.doFilter(req, resp);
        resp.getWriter().println("filterafter");


        //after最后输出，在servlet响应完之后，把响应提交给filter，filter修改响应对象
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
