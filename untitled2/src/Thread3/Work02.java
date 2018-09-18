package Thread3;

public class Work02 {
    public static void main(String args[]){
        Work02Container work02Container=new Work02Container();
        Thread1 thread1=new Thread1(work02Container);
        Thread2 thread2=new Thread2(work02Container);
        new Thread(thread1).start();
        new Thread(thread2).start();
    }
}
