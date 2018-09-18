package ThreadPool;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    public static void main(String[] args) {
        //定义一个定时器
        // 在timer中所有的定时任务都是运行在同一个线程中
        Timer timer = new Timer();

        //在定时器上调度，定时任务
//        timer.schedule(new MyTimerTask(), 3000);
//       timer.schedule(new MyTimerTask(), 1000);

        //调度器重复执行定时任务
        timer.schedule(new MyTimerTask(), 0, 2000);
    }
}


class MyTimerTask extends TimerTask {

    //Timer timer=new Timer();
    /*public MyTimerTask(Timer timer) {
        this.timer = timer;
    }*/

    @Override
    public void run() {
        //在输出之前，取消定时任务
        //cancel();

        //利用Timer的cancel方法取消定时任务,其实timer的cance方法，是终止Timer本身
        //timer.cancel();
        System.out.println("hello timer");

    }
}
