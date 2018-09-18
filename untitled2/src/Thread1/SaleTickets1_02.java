package Thread1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*
        模拟售票的第二个问题：
        不存在的票，被卖出多次

        Thread-1: 已售出第1张票
        Thread-0: 已售出第0张票
        Thread-2: 已售出第-1张票

        其核心原因是因为，对于tickets的值而言，判断tickets>0 到真正售出票这个动作不是一步完成，
        在判断票数，和售票动作之间，可能会发生线程切换

        问题1产生的原因是因为：tickets--不是一步完成（a b c 之间都有可能发生线程切换）
        问题2产生的原因是因为：判断票数是否足够和售票动作，不是一次完成的(在这两个动作之间可能发生线程切换)

        都是某一个动作不是一次完成的，在该动作执行的过程中，因为线程间切换的存在，
        线程间共享数据可能被其他线程所修改

        如何解决这个问题呢？
        如何让tickets--这个动作，与（判断和销售）分别一次性完成，这两种动作中间，不发生线程切换，
        这两个问题就都不会发生了。

        -》 java语言能不能阻止一下线程的切换？java语言做不到，但是可以阻止其他线程，对共享变量的访问


        发生线程安全问题的三个条件：
        1. 多线程运行环境
        2. 多线程访问线程共享数据（存在共享数据）
        3. 访问共享数据的操作不是原子操作。
        当这三个条件同时满足的时候，才会发生多线程的数据安全问题

        原子操作：不可分割的操作 《=》一次性完成的操作

        解决多线程的线程安全问题，-》 如何实现，线程对共享资源的排他性使用
 */

public class SaleTickets1_02 {

    public static void main(String[] args) {

        RunnableSaleWindow1 runnableSaleWindow = new RunnableSaleWindow1();

        //3个窗口共同卖这100张票（很方便的实现多线程数据的共享）
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();
    }
}


class  RunnableSaleWindow1 implements Runnable {

    int ticktes = 100;

    @Override
    public void run() {
        //假设tickets的值是1
        //首先是，线程1判断tickets的值1 > 0 ，进入循环，执行休眠语句，发生线程切换
        //        线程0执行， tickets的值还是1，进入循环，执行休眠语句，发生线程切换
        //        线程2执行,  tickets的值还是1，进入循环执行休眠语句，发生线程切换

        //        线程1：Thread-1：已售出第1张票 （此时tickets的值是0）
        //        线程0：Thread-0：已售出第0张票 （此时tickets的值已经变成了-1）
        //        线程2：Thread-2：已售出第-1张票 （ticktets的值已经变成-2）
        while (ticktes > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);

                System.out.println(Thread.currentThread().getName() + ": 已售出第" + ticktes-- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


