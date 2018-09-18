package com.controller;

import com.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "JsonServlet",urlPatterns = "/findUserById")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        //查询数据库，得到对应的user的信息
        User user=new User();

        /*String json=  "{\"id\":\""+user.getId()+"\","+
                      "\"username\":\""+user.getUsername()+"\","+
                       "\"age\":\""+user.getAge()+"\","+
                       "\"telephone\":\""+user.getTelephone()+"\","+
                       "\"addr\":\""+user.getAddr()+ "\"}";*/

        //{ret:1,url=asda};

        Map<String,String> hashmap =new HashMap<String,String>();

        hashmap.put("ret","1");
        hashmap.put("url","http://localohst/xx");



        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(hashmap);

        System.out.println("json="+s);

        response.getWriter().println(s);

    }
}
