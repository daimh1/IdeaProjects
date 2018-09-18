public class Testwork1 {
    public static void main(String args[]){
        Dog a=new Dog();
        Ben b=new Ben();
        a.bark();
        b.bark();
    }
}
class Dog{
    public static void bark(){
        System.out.println("woof");
    }
}
class Ben extends Dog{
    public static void bark(){

    }
}
