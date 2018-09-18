package com.homework04.controller;

import com.homework04.service.AccountService;
import com.homework04.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Work04 {
    @RequestMapping("/work04")
    public String transfer(int from,int to,int money){

        System.out.println(from+" "+to+" "+money);
        AccountService service=new AccountServiceImpl();
        service.transfer(from,to,money);

        return "/index.jsp";
    }
}
