package com.qq.daimh1;

public class T1 {
    public static void main(String args[]){
        System.out.print(by("127"));
    }
    public static boolean  mat(String abc){
        boolean b=abc.matches("[0-9][1-9]{4,9}");
        return b;
    }
    public static byte by(String abc){
        byte a=Byte.parseByte(abc);
        return a;
    }
}
