package Thread1;

import java.util.concurrent.TimeUnit;

public class SynchronizedBlock {

    public static void main(String[] args) {

        RunnableSaleWindow2 runnableSaleWindow = new RunnableSaleWindow2();
        //3个窗口共同卖这100张票（很方便的实现多线程数据的共享）
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();

    }
}
class RunnableSaleWindow2 implements Runnable {

    int ticktes = 100;

    int i = 0;

    final static Object SYNC_LOCK1 = new Object();
    final static Object SYNC_LOCK2 = new Object();

    @Override
    public void run() {
        while (ticktes > 0) {
            saleOneTicket();
        }
    }

    private void saleOneTicket() {
        try {
                TimeUnit.MILLISECONDS.sleep(10);
                synchronized (SYNC_LOCK1) {
                   if (ticktes > 0) {
                        System.out.println(Thread.currentThread().getName() + ": 已售出第" + ticktes + "张票");
                        ticktes--;
                    }


                }


            /*TimeUnit.MILLISECONDS.sleep(20);
            if (ticktes > 0) {
                System.out.println(Thread.currentThread().getName() + ": 已售出第" + ticktes-- + "张票");

            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
