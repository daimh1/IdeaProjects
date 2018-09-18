package IO;

public class ThreadPriority {
    public static void main(String[] args) {

        FirstThread thread1 = new FirstThread();
        FirstThread thread2 = new FirstThread();


        // 尽量不要写 hard code
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        //System.out.println(thread1.getPriority());

        thread1.start();
        thread2.start();

    }

}

class FirstThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "--" + i);
        }
    }
}

