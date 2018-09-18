public class Class4_q4 {
    public static void println(boolean x,boolean y){
        System.out.println("第一个输入值为："+x);
        System.out.println("第二个输入值为："+y);
    }
    public static void println(int x,int y){
        System.out.println("第一个输入值为："+x);
        System.out.println("第二个输入值为："+y);
    }
    public static void println(String x,String y){
        System.out.println("第一个输入值为："+x);
        System.out.println("第二个输入值为："+y);
    }
    public static void println(double x,double y){
        System.out.println("第一个输入值为："+x);
        System.out.println("第二个输入值为："+y);
    }
    public static void println(char x,char y){
        System.out.println("第一个输入值为："+x);
        System.out.println("第二个输入值为："+y);
    }
    public static void main(String args[]){
        println(1.2,3.4);
        println("abc","def");
    }
}
