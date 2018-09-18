package homework03.com.cskaoyan.test;

import org.testng.annotations.Test;

public class MyThreadLocal {


    @Test
    public void testThreadLocal()   {

        ThreadLocal<String>  myThreadLocal=new ThreadLocal<String>();

        myThreadLocal.set("zhangsan");

        String s = myThreadLocal.get();

        System.out.println("s="+s);

        new MyThread(myThreadLocal).start(); //s=?

        Thread thread = Thread.currentThread();
        try {
            thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String s2 = myThreadLocal.get();

        System.out.println("s2="+s2);

    }



}

class MyThread extends Thread{

    ThreadLocal<String> threadLocal;

    public MyThread(ThreadLocal<String> threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {

        String s = threadLocal.get();
        System.out.println("s in thraed ="+s);

        threadLocal.set("lisi");

        String s1 = threadLocal.get();
        System.out.println("s1 in thraed ="+s1);

    }
}
