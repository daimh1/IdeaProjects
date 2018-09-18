package Thread3;

public class Shoot implements Runnable{
    Work03Container work03Container;

    public Shoot(Work03Container work03Container) {
        this.work03Container = work03Container;
    }

    @Override
    public void run() {
        while (Work03Container.m<100){
            Bullet bullet=new Bullet();
            work03Container.shootBullet(bullet);
        }
    }
}