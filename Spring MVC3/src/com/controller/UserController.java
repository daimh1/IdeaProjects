package com.controller;


import com.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login1")
    public String login(HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        System.out.println("username:"+username);
        System.out.println("password:"+password);

        System.out.println("login");
        return "/index.jsp";
    }

    @RequestMapping("/login2")
    public String login2(String username,String password,int age){
        System.out.println("username="+username);
        System.out.println("age:"+age);
        System.out.println("password:"+password);
        return "/index.jsp";
    }

    @RequestMapping("/login3")
    public String login3(User user){
        System.out.println("User:"+user);
        return "/index.jsp";
    }
}
