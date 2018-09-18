package Day7;

public class Class7_q2 {

    public double radius;
    public double getArea(double radius){
        return 3.14*radius*radius;
    }
    public double getPerimeter(double radius){
        return 2*3.14*radius;
    }

    public double rectanglea;
    public double rectangleb;
    public double getArea(double rectanglea,double rectangleb){
        return rectanglea*rectangleb;
    }
    public double getPerimeter(double rectanglea,double rectangleb){
        return 2*(rectanglea+rectangleb);
    }

    public double trianglea;
    public double triangleb;
    public double trianglec;
    public double getArea(double trianglea,double triangleb,double trianglec){
        double p=getPerimeter(trianglea,triangleb,trianglec)/2;
        return Math.sqrt(p*(p-trianglea)*(p-triangleb)*(p-trianglec));
    }
    public double getPerimeter(double trianglea,double triangleb,double trianglec){
        return trianglea+triangleb+trianglec;
    }

    public static void main(String args[]){
        Class7_q2 xiaoming=new Class7_q2();
        System.out.println("半径为1的圆的面积为："+xiaoming.getArea(1)+"周长为："+xiaoming.getPerimeter(1));
        System.out.println("长宽为2和1的长方形的面积为："+xiaoming.getArea(2,1)+"周长为："+xiaoming.getPerimeter(2,1));
        System.out.println("三边分别为为3和2和2的三角形的面积为："+xiaoming.getArea(3,2,2)+"周长为："+xiaoming.getPerimeter(3,2,2));
    }
}
