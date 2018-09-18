package Thread3;

public class Work03 {
    public static void main(String args[]){
        Work03Container work03Container=new Work03Container();
        Charge charge=new Charge(work03Container);
        Shoot shoot=new Shoot(work03Container);
        new Thread(charge).start();
        new Thread(shoot).start();
    }
}
