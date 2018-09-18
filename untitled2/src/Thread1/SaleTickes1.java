package Thread1;

import java.util.concurrent.TimeUnit;

public class SaleTickes1 {

    public static void main(String[] args) {
        //利用线程的第一种实现形式实现(线程数据的共享不太方便)
        //启动三个售票窗口的线程来售票
//        new SaleWindow().start();
//        new SaleWindow().start();
//        new SaleWindow().start();


        //利用线程的第二种实现形式来实现

        RunnableSaleWindow runnableSaleWindow = new RunnableSaleWindow();

        //3个窗口共同卖这100张票（很方便的实现多线程数据的共享）
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();
        new Thread(runnableSaleWindow).start();

    }

}


class SaleWindow extends Thread {

    int ticktes = 100;

    @Override
    public void run() {

        // 假设，现在线程0首先启动
        // 假设，因为线程0休眠，调度到线程2
        // 假设，又因为线程2的休眠调度线程1

        //100ms后，线程0先醒过来
        while (ticktes > 0) {
            try {
                //线程0休眠
                //线程1休眠
                //线程2休眠
               Thread.sleep(100);
                //线程0： 最先开始售票执行输出方法，但是在输出方法输出之前，
                //        必须县拼接出最终要输出的字符串，假设拼接到tickets--
                //        (a. 读取tickets变量的值 b tickets -1 c tickets = tickets -1) 当执行tickets--的第a步，
                //        发生了线程切换(拼接的值tickets的值是100)


                //线程1： 线程2开始执行卖票的输出语句，同样在计算实际参数，假设线程在在计算到ticktes--的第a步的时候
                //        现在tickets的值仍然是100拼接的结果（tickets的值仍然是100）， 发生了线程切换

                //线程2： 现在线程1来执行，售票的输出语句，假设线程2，刚刚执行拼接到“已售出”，发生了线程切换

                //线程0： 执行完 Thread-0 ：已售出100 张票， tickets-- 的b和c，现在tickets的值变成了99，
                //        线程1将输出结果传递给println方法，输出 发生线程切换
                //输出 Thread-0已售出100票

                // 线程2： 接着拼接ticket--的值，又因为线程以刚刚修改了tickets的值为99，线程2拼接的结果就是
                //         Thread-2:已售出99张票，tickets-- b c 输出了结果
                //输出  Thread2：已售出99张票

                // 线程1：来执行了Thread-1：已售出100张票，执行tickets--的b和c，并执行println方法输出
                //        输出的是 Thread-1：已售出100张票


                System.out.println(getName() + ": 已售出第" + ticktes-- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

//使用线程的第二种实现形式，来实现saleWindow

class  RunnableSaleWindow implements Runnable {

    int ticktes = 100;

    @Override
    public void run() {

        while (ticktes > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + ": 已售出" + ticktes-- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

