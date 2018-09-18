package Day8;

public class Car extends ComputeTime implements Common{
    @Override

    public double speed(int A, int B, int C) {
        return A*B/C;
    }
    public Car(int A,int B,int C){
        this.A=A;
        this.B=B;
        this.C=C;
    }
    public static void main(String args[]){
        Car car=new Car(100,200,300);
        System.out.println("Car行驶1000公里需要"+car.speed(car.A,car.B,car.C));
    }
}
