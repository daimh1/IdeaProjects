package Thread3;

public class Charge implements Runnable{
    Work03Container work03Container;

    public Charge(Work03Container work03Container) {
        this.work03Container = work03Container;
    }

    @Override
    public void run() {
        while (Work03Container.m<100){
            work03Container.chargeBullet();
        }
    }
}
