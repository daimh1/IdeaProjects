package Reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
     创建合法的Student对象：
     1. 获取额外信息（获取Student对象中堆name和age这两个成员变量的约束） 通过反射来获取额外信息的值
     2. 根据name和age的约束，判断，只有要创建的student对象，满足约束的，创建该对象，否则拒绝创建


     注解定义在哪里就从哪里拿注解信息，


 */
public class StudentAnnotationHandler {

    //该字节码文件对象，就是注解处理器，要处理的那个类的字节码文件对象
    Class clazz;

    StudentAnnotationHandler(Class clazz) {
        this.clazz = clazz;
    }


    //符合约束的对象才创建，否则拒绝创建
    //
    public Student newInstance(int paramAge, String pararName) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //1. 判断参数值是否符合约束条件 name和age都满足约束，才创建该对象
            //获取name属性的约束

        //获取代表name字段的Field对象
        Field name = clazz.getDeclaredField("name");

        //判断name是否添加了NameLengthConstraint了类型的注解
        boolean annotationPresent = name.isAnnotationPresent(NameLengthContraint.class);

        if(annotationPresent) {
            //如果该字段，有添加了这样的注解信息，则获取
            //getAnnotation的返回值，是一个注解对象，这个对象中就包含，在代码中添加的额外信息
            NameLengthContraint nameAnnotation = name.getAnnotation(NameLengthContraint.class);
            //从注解对象上，获取，注解中配置项的值, 类似于方法调用
            int maxLength = nameAnnotation.maxLength();
            if(maxLength < pararName.length()) {
                //paramName不符合名字的约束，即名字包含的字符个数，不大于指定的最多的字符个数
                throw new IllegalArgumentException("参数不合法 " + pararName);
            }
        }

        //判断paramAge是否符合age属性的约束条件
        Field age = clazz.getDeclaredField("age");

        //判断，Age字段有没有添加AgeRangeConstraint这个注解
        if(age.isAnnotationPresent(AgeRangeContraint.class)) {
            //age字段有该类型的注解信息
            AgeRangeContraint ageAnnotation = age.getAnnotation(AgeRangeContraint.class);

            //获取注解中所写的age最大值和最小值
            int minAge = ageAnnotation.minAge();
            int maxAge = ageAnnotation.maxAge();

            //判断，paramAge是否符合age的约束条件
            if(paramAge >= minAge && paramAge <= maxAge) {
                //如果满足约束条件，现在age和name就都已经满足了，就该创建对象了

                Constructor stuConstructor = clazz.getConstructor(String.class, int.class);

                return (Student)stuConstructor.newInstance(pararName, paramAge);

            }
        }

        throw new IllegalArgumentException("参数非法 " + paramAge);

    }

}
