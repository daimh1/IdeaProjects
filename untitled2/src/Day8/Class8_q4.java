package Day8;

public class Class8_q4 {
    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }


    void defaultMethod() {
        System.out.println("接口中的默认方法");
    }
    public static void main(String args[]){
        staticMethod();
        Class8_q4 class8_q4=new Class8_q4();
        class8_q4.defaultMethod();
    }
}
