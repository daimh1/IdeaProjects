package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MyController {

    @RequestMapping("/login")
    public  String login(Model model){


        System.out.println("login!");

        model.addAttribute("","");

        return "jsp/index";
    }


    @RequestMapping("/testFtl")
    public String testFtl(Model model){

        model.addAttribute("name","zhangsan");
        //map.put("name","zhangsan");

        return  "ftl/template";
    }
}
