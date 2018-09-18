package Thread3;

public class Thread2 implements Runnable{
    Work02Container work02Container;

    public Thread2(Work02Container work02Container) {
        this.work02Container = work02Container;
    }

    @Override
    public void run() {
        while (Work02Container.num<100){
            work02Container.Threadadd2();
        }
    }
}

