package com.myweb.controller;


import com.myweb.bean.User;
import com.myweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session){

        //请求参数的合法验证

        User login = userService.login(username, password);

        ModelAndView modelAndView = new ModelAndView();
        if (login==null){

            //用户不存在
            modelAndView.setViewName("/login.jsp");
            modelAndView.addObject("msg","用户名或者密码不对！");

        }else{

            //登录成功
            //放到session里

            session.setAttribute("user",login);
            modelAndView.setViewName("/user.jsp");

        }
        return modelAndView;


    }

}
