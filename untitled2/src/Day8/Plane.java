package Day8;

public class Plane extends ComputeTime implements Common{
    @Override

    public double speed(int A, int B, int C) {
        return A+B+C;
    }
    public Plane(int A,int B,int C){
        this.A=A;
        this.B=B;
        this.C=C;
    }
    public static void main(String args[]){
        Plane plane=new Plane(100,200,300);
        System.out.println("Plane行驶1000公里需要"+plane.speed(plane.A,plane.B,plane.C));
    }
}

