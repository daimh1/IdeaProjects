package com.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class User {

    String username123 ;
    String password ;
    int age ;

    Teacher teacher;

    String[] hobby;

    ArrayList<Shoe> shoes;

    Date birthday ;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /* public String getUsername123() {
        return username123;
    }

    public void setUsername123(String username123) {
        this.username123 = username123;
    }*/

   public ArrayList<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(ArrayList<Shoe> shoes) {
        this.shoes = shoes;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getUsername() {
        return username123;
    }

    public void setUsername(String username) {
        this.username123 = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "username123='" + username123 + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                ", hobby=" + Arrays.toString(hobby) +
                ", shoes=" + shoes +
                ", birthday=" + birthday +
                '}';
    }
}
