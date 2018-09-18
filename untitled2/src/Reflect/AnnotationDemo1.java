package Reflect;

/*
     注解：
     一种Java语言用来在代码中添加额外信息的形式化方法，
     使得Java程序可以在编译或者运行之后的某个时刻，很方便的去使用这些额外信息（数据）

     还有一种向代码添加额外信息的方式：注释，也是一种向代码中添加额外信息的，这种方式，
     添加的额外信息，只有开发者能看得懂，我们无法通过代码从注释中，获取一些关键


 */

public class AnnotationDemo1 {

    public static void main(String[] args) {

        //调用被Deprecated注解所标明的方法
        test();
    }


    //表示该方法已经过时了
    @Deprecated
    @RunTime(timeLimit = 100)
    private static void test() {

    }
}
