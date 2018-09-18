package Reflect.Ex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Demo2 {
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class test=Class.forName("Reflect.Ex.TestConstructor");//只能访问public声明的构造器
        Constructor[] constructors=test.getConstructors();
        System.out.println(Arrays.toString(constructors));

        System.out.println();
        Constructor[] declaredConstructors = test.getDeclaredConstructors();//可以访问任意被声明的构造器
        System.out.println(Arrays.toString(declaredConstructors));

        System.out.println();
        Constructor constructor = test.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Constructor declaredConstructor = test.getDeclaredConstructor(String.class, int.class,double.class);
        System.out.println(declaredConstructor);

        Object lisi=constructor.newInstance("lisi",200);
        System.out.println(lisi);

        declaredConstructor.setAccessible(true);
        Object zs = declaredConstructor.newInstance("zs", 30, 100);
        System.out.println(zs);
    }

}
class TestConstructor{
    String name;
    int age;
    double weight;

    public TestConstructor(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public TestConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private TestConstructor(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    TestConstructor(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestConstructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}