package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class MyController {

    @RequestMapping("/test")
    public String test(Model model) {

        System.out.println("test");

        model.addAttribute("name","zhangsan");

        //int i=1/0;

        return  "/index.jsp";
    }


}
