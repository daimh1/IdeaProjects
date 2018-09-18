package Day17;

import java.util.Date;
import java.util.Timer;

public class Work02 {
    public static void main(String args[]){
        Timer timer=new Timer();
        timer.schedule(new TimerTask("a"),1000L);
        timer.schedule(new TimerTask("b"),new Date(System.currentTimeMillis()+2000));
        timer.schedule(new TimerTask("c"),0,2000);
        timer.schedule(new TimerTask("d"),new Date(System.currentTimeMillis()+500),2000);
        timer.scheduleAtFixedRate(new TimerTask("e"),new Date(System.currentTimeMillis()+500),2000);//执行时间不会延后
        timer.scheduleAtFixedRate(new TimerTask("f"),0,2000);
    }
}

class TimerTask extends java.util.TimerTask {
    String name;
    public TimerTask(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){}
        System.out.println(name+"  Hello World!");
    }
}