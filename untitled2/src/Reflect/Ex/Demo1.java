package Reflect.Ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo1 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Demo1 obj = new Demo1();
        System.out.println(obj.getClass());

        Class<Demo1> reflectDemo1Class = Demo1.class;
        System.out.println(reflectDemo1Class);

        Class<A> aClass=A.class;

        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("loadClass.properties");

        property.load(fis);

        Class reflectDemo1 = Class.forName(property.getProperty("load"));
        System.out.println(reflectDemo1);
    }
}

class A{
    static {
        System.out.println("static test");
    }
}