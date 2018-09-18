package Thread1;

public class Work02 {
    public static void main(String args[]){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }) {
            //@Override
            public void run() {
                System.out.println("world");
            }
        }.start();
    }
}
//输出的是world因为Runnable接口中的run方法线被实现，然后新建的Thread对象再重写了run方法，
// 如果注释掉Thread内的重写部分，那么则运行之前接口实现的run方法，即输出hello
//

//class
