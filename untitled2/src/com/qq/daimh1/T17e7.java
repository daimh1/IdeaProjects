package com.qq.daimh1;

import java.util.ArrayList;
import java.util.List;

public class T17e7 {
    public static void main(String args[]){
        List list = new ArrayList();
        Student stu1=new Student("zhangsan",5,98,130);
        list.add(stu1);
        Student stu2=new Student("lisi",3,95,150);
        list.add(stu2);
        Student stu3=new Student("wangwu",4,100,120);
        list.add(stu3);
        Student stu4=new Student("zhaoliu",6,91,140);
        list.add(stu4);
        Student stu5=new Student("qianqi",7,93,150);
        list.add(stu5);
        System.out.println("高：");
        new Height().RowSeat(list);
    }

}
class  Height implements  Runnable{
    Thread thread;
    Height(){

    }
    Height(String name){
        thread=new Thread(this,name);
    }
    public void run(){
        System.out.println("一年一班的学员"+thread.getName());
    }
    public void RowSeat(List list){
        Student st=(Student) list.get(0);
        Student st1=(Student) list.get(1);
        Student st2=(Student) list.get(2);
        Student st3=(Student) list.get(3);
        Student st4=(Student) list.get(4);

        Height o1 =new Height(st.name);
        Height o2 =new Height(st1.name);
        Height o3 =new Height(st2.name);
        Height o4 =new Height(st3.name);
        Height o5 =new Height(st4.name);

        o1.thread.setPriority(Thread.NORM_PRIORITY-1);
        o2.thread.setPriority(Thread.MAX_PRIORITY);
        o3.thread.setPriority(Thread.MIN_PRIORITY);
        o4.thread.setPriority(Thread.NORM_PRIORITY);
        o5.thread.setPriority(Thread.MAX_PRIORITY-1);


        o1.thread.start();
        o2.thread.start();
        o3.thread.start();
        o4.thread.start();
        o5.thread.start();
        try {
            o5.thread.join();
        }catch (InterruptedException e){
            System.out.println("出错："+e.getMessage());
        }
    }
}

class Student{
    public String name;
    public int age;
    public int score;
    public int height;

    public Student(String name,int age,int score,int height){
        this.name=name;
        this.age=age;
        this.height=height;
        this.score=score;
    }
}