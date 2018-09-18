package Day8;

public class Ship extends ComputeTime implements Common{
    @Override

    public double speed(int A, int B, int C) {
        return A+B/C;
    }
    public Ship(int A,int B,int C){
        this.A=A;
        this.B=B;
        this.C=C;
    }
    public static void main(String args[]){
        Ship ship=new Ship(100,200,300);
        System.out.println("Car行驶1000公里需要"+ship.speed(ship.A,ship.B,ship.C));
    }
}
