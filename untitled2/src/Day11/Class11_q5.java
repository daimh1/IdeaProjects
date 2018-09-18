package Day11;

public class Class11_q5 {
    public static void main(String args[])throws Exception{
        try {
            People p1=new People(1,"",19);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            People p2=new People(2,"a",17);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            People p3=new People(500,"123456789");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
