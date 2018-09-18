package com.qq.daimh1;

public class T2 {
    public static void main(String args[]){
        int a,b;
        try{
            a=0;
            b=5/a;
            System.out.println("检验");
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        System.out.println("结束");
    }
}
