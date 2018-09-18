package com.homework03.bean;

public class Pig implements Animal{
    public void action(){
        System.out.println(this.getClass().getName()+" is pig");
    }
}
