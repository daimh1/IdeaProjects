package Reflect.Ex;

public class ClassTest{
    String str = "hello";
    char[] ch = {'a','b','c'};
    public void fun(String str, char ch[]){
        //int i=str.indexOf("e");
        /*String str2=String.valueOf(str.charAt(i));
        System.out.println(str2);*/
        str=str.replaceFirst("e","a");
        ch[0]='d';
        ch=new char[2];
        System.out.println(str);
    }
    public static void main(String[] args) {
        ClassTest test1 = new ClassTest();
        test1.fun(test1.str,test1.ch);
        System.out.print(test1.str + " and ");
        System.out.print(test1.ch);
    }
}