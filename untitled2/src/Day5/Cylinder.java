package Day5;

public class Cylinder extends Circle{
    private double hight;
    public Cylinder(double r,double h){
        Radius=r;
        hight=h;
    }
    double getVolume(){
        return getArea()*hight;
    }
    void showVolume(){
        System.out.println("圆柱体体积为"+getVolume());
    }
    public static void main(String args[]){
        Cylinder cylinder=new Cylinder(0.5,5);
        //cylinder.showVolume();
        cylinder.setX(2);
        cylinder.setY(3);
        System.out.println("当前圆柱体轴心位置：("+cylinder.x+","+cylinder.y+")，半径："+cylinder.Radius+"面积："+cylinder.getArea()+"高："+cylinder.hight+"体积："+cylinder.getVolume());

    }
}
