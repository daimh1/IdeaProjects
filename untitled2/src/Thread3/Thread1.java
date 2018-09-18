package Thread3;

public class Thread1 implements Runnable{
    Work02Container work02Container;

    public Thread1(Work02Container work02Container) {
        this.work02Container = work02Container;
    }

    @Override
    public void run() {
        while (Work02Container.num<100){
            work02Container.Threadadd1();
        }
    }
}
