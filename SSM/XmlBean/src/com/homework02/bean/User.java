package com.homework02.bean;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class User {
    String username;
    String password;

    Cellphone cellphone;
    private String[] hobbys;

    private Properties hobbys2;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cellphone=" + cellphone +
                ", hobbys=" + Arrays.toString(hobbys) +
                ", hobbys2=" + hobbys2 +
                ", hobbys3=" + hobbys3 +
                '}';
    }

    public Map<String, String> getHobbys3() {
        return hobbys3;
    }

    public void setHobbys3(Map<String, String> hobbys3) {
        this.hobbys3 = hobbys3;
    }

    public Properties getHobbys2() {
        return hobbys2;
    }

    public void setHobbys2(Properties hobbys2) {
        this.hobbys2 = hobbys2;
    }



    private Map<String,String> hobbys3;

    public Cellphone getCellphone() {
        return cellphone;
    }

    public void setCellphone(Cellphone cellphone) {
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String[] getHobbys() {
        return hobbys;
    }

}
