package com.homework03.bean;

public class Cat implements Animal{
    public void action(){
        System.out.println(this.getClass().getName()+" is cat");
    }
}
