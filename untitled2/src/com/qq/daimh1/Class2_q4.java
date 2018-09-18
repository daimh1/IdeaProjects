package com.qq.daimh1;
import java.util.*;

public class Class2_q4 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字：");
        int num=sc.nextInt();
        sc.close();
        //int temp=num;
        //boolean judge=false;
       //judege(num);
       System.out.println(judege(num));
    }
    public static boolean judege(int num){
        if(num==0){return false;}
        while (num!=1){
            if(num%2==1){
                return false;
            }
            num=num/2;
        }
        return true;
    }
}
