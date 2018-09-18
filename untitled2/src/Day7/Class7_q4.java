package Day7;

public class Class7_q4 {
    public static void main(String args[]){
        A a=new B();
        a.eat();//向上转型
        A c=new C();
        c.eat();//向上转型
        B b1=((B) a);
        b1.eat();
        //C c1=((C) a);
        B b2=((C) c);
        b2.eat();
        B b3=((C) a);//向下转型失败，原因：让属于B类的a转型成了B的子类C，向下转型不能让原本属于父类的对象转为属于子类对象
        b3.eat();
    }
}

class A{
    public void eat(){
        System.out.println("这是一个A");
    }
}
class B extends A{
    public void eat(){
        System.out.println("这是一个B");
    }
}
class C extends B{
    public void eat(){
        System.out.println("这是一个C");
    }
}