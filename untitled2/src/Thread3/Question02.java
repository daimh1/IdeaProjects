package Thread3;

public class Question02 extends Thread{
    int num=0;
    final static Object LOCK=new Object();

    @Override
    public void run() {
        while(num<100){
            synchronized (LOCK){
                LOCK.notify();
                System.out.println(Thread.currentThread().getName()+": "+num++);
                try {
                    LOCK.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(num==100){
                    LOCK.notify();
                }
            }
        }


    }
    public static void main(String args[]){
        Question02 question02=new Question02();
        new Thread(question02).start();
        new Thread(question02).start();
    }
}
