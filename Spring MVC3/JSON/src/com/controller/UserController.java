package com.controller;


import com.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    @RequestMapping("/findUserById")
    public User findUserById(@RequestBody User id){

        System.out.println("id="+id);

        // User user=new User(1,"zhangsan","22","123456789","shenzhen");
        //User user=new User(1,"zhangsan",22,"123456789","shenzhen");

        return id;
    }


    /**
     * 注册之后返回值
     * success:1 成功
     * url:跳转的页面
     *
     * success:0 失败
     *  失败的原因
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Map register(@RequestBody  User user){

        System.out.println("user="+user);


        HashMap<String,Object> ret=new HashMap<>();
        //参数校验
        if (user.validate()){


            //插入数据库


            ret.put("success",1);
            ret.put("url","/index.jsp");


        }else{

            ret.put("success",0);
            ret.put("msg",user.getErrmsg());
        }




        return ret;
    }
}
