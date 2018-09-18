package com.qq.daimh1;
import java.util.*;

public class Class2_q2 {
    public static void Judge1(int num){
        if(num>=100){
            System.out.println("A");
        }
        else if(num<100&&num>=70){
            System.out.println("B");
        }
        else if(num>=50&&num<70){
            System.out.println("C");
        }
        else if(num>=30&&num<50){
            System.out.println("D");
        }else{
            System.out.println("E");
        }
    }
    public static String Judege2(int num){

       return num>=100?"A":num>=70?"B":num>=50?"C":num>=30?"D":"E";
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num=sc.nextInt();
        sc.close();
        Judge1(num);
        System.out.println(Judege2(num));
    }
}
