package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Homework03 {
    @ResponseBody
    @RequestMapping("/findcity")
    public void findcity(@RequestBody String province) throws JsonProcessingException {
        System.out.println(province);
        Map<String,String> hashmap =new HashMap<String,String>();
        if(province.equals("province=1")){
            hashmap.put("city1","广州");
            hashmap.put("city2","深圳");
        }else if(province.equals("province=2")){
            hashmap.put("city1","福州");
            hashmap.put("city2","厦门");
        }
        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(hashmap);

        System.out.println("json="+s);
    }
}
