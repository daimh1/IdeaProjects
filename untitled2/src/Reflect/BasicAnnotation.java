package Reflect;

/*
        定义注解格式：
        public @interface 注解名 {
            定义体
        }

        注意事项：
        1.@必不可少
        2.使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。
        3.在定义注解时，不能继承其他的注解或接口。

        注解信息，都是键值对的形式存在的


        定义体的解释：
        1.方法的名称就是参数的名称，返回值类型就是参数的类型
         （返回值类型只能是基本类型、Class、String、enum, 注解）。


        2.方法不用写具体实现

        3.一个方法表示一个配置（一条额外信息  一个键值对）

        4.如果它这个方法名是value，表示配置项名称是value，那么在给这个配置项赋值的时候，不用再去写配置的
          名字 =，直接写值即可(当且仅当只有名为value的配置需要赋值的时候)


        5.方法之后可以使用 default 默认值

        注解：
           可以在3个地方添加：
           a. 在类定义之前
           b. 成员变量定义之前
           c. 成员方法定义之前
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 定义了一个名为BasicAnnotation的注解
@Retention(RetentionPolicy.RUNTIME)
public @interface BasicAnnotation {

    //在定义体中定义注解(定义键值对)  key的名字，value的数据类型
    //name = 字符串类型的值

    //形式上类似于方法定义
     String name() default "";  // name = 字符串类型的值

  //  Second test(); // test = 数据类型是注解类型

    int value();
}

@interface Second{

    double se();
}


//@BasicAnnotation(value = 1, test = @Second(se = 1))
//class A {
//
//}
