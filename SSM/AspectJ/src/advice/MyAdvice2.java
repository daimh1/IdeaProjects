package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class MyAdvice2 {

    public void print1(JoinPoint joinPoint){
        System.out.println("before");

        Object[] args = joinPoint.getArgs();
        System.out.println("arrs="+ Arrays.toString(args));
    }
    public void print2(JoinPoint joinPoint,Object ret){

        System.out.println("after Returning!" +ret);

    }


    //环绕通知
    //通知在切入点之前 和之后都会执行
    //可以增加事务操作
    public Object print3(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed=null;
        System.out.println("around before");
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }

        System.out.println("around after");

        return  proceed;

    }

    //抛出异常的通知
    public void print4(Exception e){

        System.out.println("after throwing!@" +e.getMessage());

    }


    //最终通知 final
    public  void print5(){

        System.out.println("final advice!");
    }
}
