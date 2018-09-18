package Thread2;

import java.util.concurrent.TimeUnit;

public class Work03 {
    public static void main(String args[]){
        SaleWindow saleWindow=new SaleWindow();
        new Thread(saleWindow).start();
        new Thread(saleWindow).start();
        new Thread(saleWindow).start();

    }
}

class SaleWindow extends Thread{
    int tickets=100;
    int i=0;
    final static Object LOCK1=new Object();

    public void run(){
        saleTickets();
    }

    private synchronized void saleTickets() {
        try {
            while (tickets>0){
            TimeUnit.MILLISECONDS.sleep(100);
            //synchronized (LOCK1) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ": 已售出第" + tickets + "张票");
                    tickets--;
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}