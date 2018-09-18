package Thread3;

public class Work02Container{
    boolean isThread1=true;
    static int num=0;
    public synchronized void Threadadd1(){
        if(isThread1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {

            System.out.println(Thread.currentThread().getName()+": "+num++);
            this.isThread1=true;
            this.notify();
            //return num;
        }
        //return 0;
    }
    public synchronized void Threadadd2(){
        if(!isThread1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {

            System.out.println(Thread.currentThread().getName()+": "+num++);
            this.isThread1=false;
            this.notify();
        }
    }
}
