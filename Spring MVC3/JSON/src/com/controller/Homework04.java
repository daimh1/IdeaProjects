package com.controller;

import com.bean.Phone;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class Homework04 {

    @ResponseBody
    @RequestMapping("/phone")
    public Phone search(@RequestBody String phone) throws SQLException {
        Phone newphone=new Phone();

        String phonenum=front(phone);
        int length=phone.length();
        newphone=searchPhonenum(phonenum);

        return newphone;
    }

    public Phone searchPhonenum(String s) throws SQLException {
        QueryRunner qr=new QueryRunner();
        String sql = "select * from number where phonenum=?";
        Phone phone = qr.query(sql, new BeanHandler<>(Phone.class), s);
        System.out.println(phone);
        return phone;
    }

    public String front(String num) {
        char[] chars = num.toCharArray();
        String result = new String(chars, 0, 7);
        return result;
    }
}
