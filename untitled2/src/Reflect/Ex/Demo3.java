package Reflect.Ex;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Demo3 {
    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException {
        Class t=TestField.class;
        Field[] fields=t.getFields();
        System.out.println(Arrays.toString(fields));

        System.out.println();
        Field[] declaredFields = t.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        System.out.println();
        Field name = t.getField("name");
        System.out.println(name);

        System.out.println();
        Field height = t.getDeclaredField("height");
        System.out.println(height);

        TestField zs = new TestField("zs", 18, 120, 180);
        Field name1 = t.getField("name");

        //在指定对象上，获取字段的值(对象)
//        Object nameValue = name.get(zs);
//        System.out.println(nameValue);

        //在指定对象上获取，基本数据类型字段的值
//        Field i = t.getField("i");
//        int iValue = (int) i.get(zs);
//        System.out.println(iValue);
//
        //访问单个，非公共字段的值
        Field height1 = t.getDeclaredField("height");
        //设置该标志位为true,使用是不做权限检查
//        height.setAccessible(true);
//        System.out.println(height.get(zs));

        //访问当个非公共的静态字段
        Field k = t.getDeclaredField("k");
        //获取静态字段的值
//        Object o = k.get(null);
//        System.out.println(o);

        //修改成员变量的值(公共和非公共成员变量都可以修改)
        //暴力破解
        height.setAccessible(true);
        height.set(zs,150);
        System.out.println(zs);
    }
}
class FatherFields {
    public String name = "father";

    public int i = 100;

    private int fatherAage = 50;
}
class TestField extends FatherFields{

    public String name = "son";

    int age = 20;

    protected double weight = 100;

    private double height = 183;

    //静态成员变量
    static int k = 50;

    public TestField(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String toString() {
        return "TestField{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }





}
