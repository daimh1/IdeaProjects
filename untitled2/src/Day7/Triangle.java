package Day7;
import java.math.*;

public class Triangle {
    public double trianglea;
    public double triangleb;
    public double trianglec;
    public double getArea(){
        double p=getPerimeter()/2;
        return Math.sqrt(p*(p-trianglea)*(p-triangleb)*(p-trianglec));
    }
    public double getPerimeter(){
        return trianglea+triangleb+trianglec;
    }
}
