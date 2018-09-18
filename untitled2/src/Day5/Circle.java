package Day5;

public class Circle extends Point{
    protected double Radius;
    public Circle(){

    }
    public Circle(double r){
        this.Radius=r;
    }
    public double getArea(){
        return Radius*Radius*3.14;
    }
    public double getPerimeter(){
        return 2*3.14*Radius;
    }
    public void show(){
        System.out.println("圆的半径为："+Radius+"面积为："+getArea()+"周长为："+getPerimeter());

    }
    public static void main(String args[]){
        Circle circle=new Circle(0.5);
        circle.show();
    }
}
