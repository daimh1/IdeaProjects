package Thread1;

public class Work02Practice {
    public static void main(String[] args) throws InterruptedException {
        Source s=new Source();
        ThreadTest fir=new ThreadTest(s,"zs");
        Thread Fir=new Thread(fir);
        ThreadTest sec=new ThreadTest(s,"lisi");
        Thread Sec=new Thread(sec);

        Fir.start();
        //Fir.join();//fir优先运行
        //Fir.yield();
        //Sec.setDaemon(true);//守护线程，当只有守护线程运行时，直接结束所有守护线程
        Sec.start();

    }

}

class ThreadTest implements Runnable{
    private String name;
    Source s=null;

    public String getName() {
        return name;
    }

    public ThreadTest() {
    }
    public ThreadTest(Source s,String name) {
       this.name=name;
       this.s=s;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++) {

            s.print(getName(),i);
        }
        }
    }
class Source{
    synchronized void print(String name,int i){//相当于只有一台打印机

            System.out.println(name + ":" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}