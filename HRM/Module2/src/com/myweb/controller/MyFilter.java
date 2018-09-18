package com.myweb.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    private String encode = null;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        /*
         * 判断在web.xml文件中是否配置了编码格式的信息
         * 如果为空，则设置编码格式为配置文件中的编码格式
         * 否则编码格式设置为GBK
         */
        if(this.encode != null && !this.encode.equals("")){
            request.setCharacterEncoding(this.encode);
            response.setCharacterEncoding(this.encode);
        }else{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
