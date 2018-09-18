package Reflect;


// 1. 学生的名字字符串长度不能多于5个字符
// 2. 学生的年龄的范围[20,30]

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@BasicAnnotation(name="zs", value = 2)
public class Student {

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //一旦给成员定义了注解，那么该注解信息，就会出现在代表该字段的
    // Field对象中
    @NameLengthContraint(maxLength = 5)
    @AgeRangeContraint(minAge = 20, maxAge = 30)
    String name;

    @AgeRangeContraint(minAge = 20, maxAge = 30)
    int age;
}

//关于名字的注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NameLengthContraint {

    //对于名字的约束的额外信息
    int maxLength();

}

@Retention(RetentionPolicy.RUNTIME)

@interface AgeRangeContraint{

    //年龄的下界
    int minAge();

    //年龄的上界
    int maxAge();
}
