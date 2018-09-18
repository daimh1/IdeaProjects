package com.homework03;

import com.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Work03 {

    @RequestMapping("/work03")
    public String login3(User user){
        System.out.println("User:"+user);
        return "/index.jsp";//不能获取到teacher中的shoe
    }
}
