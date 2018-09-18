package com.homework03.test;

import com.homework03.bean.Animal;
import com.homework03.bean.Cat;
import com.homework03.bean.Dog;
import com.homework03.bean.Pig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Animal dog= (Animal) applicationContext.getBean("dog");
        Animal pig= (Animal) applicationContext.getBean("pig");
        Animal cat= (Animal) applicationContext.getBean("cat");

        dog.action();
        pig.action();
        cat.action();
    }
}
