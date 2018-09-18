package Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class TestAnnotationHandler {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        StudentAnnotationHandler handler = new StudentAnnotationHandler(Student.class);
//
        handler.newInstance(50, "abcdefg");


        //获取Student类的注解
        Class studentClass = Student.class;

        boolean annotationPresent = studentClass.isAnnotationPresent(BasicAnnotation.class);

        if(annotationPresent) {

            BasicAnnotation annotation = (BasicAnnotation) studentClass.getAnnotation(BasicAnnotation.class);

            System.out.println(annotation.name());
        }


    }

}
