package Day7;

public class Class7_q3 {
    public static void main(String[] args) {
        Son son = new Son();
        son.printI();
        //System.out.println(son.i);
    }

}

class Father {

    int i = 100;
    public Father() {
        System.out.println("super field = " + i);
        //i=300;
        printI();
    }


    public void printI() {
        System.out.println("super method = " + i);
    }

}

class Son extends Father{
    //{int i = 200;}
    //static {int i = 200;}
    int i = 200;
    //public void printI() { System.out.println("super method = " + i); }
    public Son(){

        super();
        //i=200;
    }


}