package com.homework03.bean;

public class Dog implements Animal{
    public void action(){
        System.out.println(this.getClass().getName()+" is dog");
    }
}
