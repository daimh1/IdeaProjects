package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Homework02 {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username, String password){
        HttpSession session=request.getSession();
        session.setAttribute("user",username);
        return  "/index.jsp";
    }
}
