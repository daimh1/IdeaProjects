package com.bean;

import java.util.HashMap;

public class User {

    int id ;
    String username ;
    String password;
    int age ;
    String telephone;
    String addr;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    HashMap<String,String> errmsg=new HashMap<>();

    public HashMap<String, String> getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(HashMap<String, String> errmsg) {
        this.errmsg = errmsg;
    }

    public boolean validate(){

        //判断用户名
        if (username.length()<6||username.length()>12){

            errmsg.put("username","用户名长度超出范围");
        }

        //密码
        if (password.length()<6||username.length()>8){

            errmsg.put("password","密码长度超出范围");
        }
        //年龄的合法性
        if (age>18||age<60){

            errmsg.put("age","年龄不合法");
        }

        return  errmsg.isEmpty();

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", telephone='" + telephone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public User(int id, String username, int age, String telephone, String addr) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.telephone = telephone;
        this.addr = addr;
    }

    public User() {
    }
}
