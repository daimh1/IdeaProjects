package Day4;

public class Class6_q3 {
    public static int fangfa(int n){
        //int count=0;
        //count++;
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
        else if(n==2) {
            return 2;
        }else {
                return fangfa(n-1)+fangfa(n-2);
            }
        }

    public static void main(String args[]){

        System.out.println("共有"+fangfa(4)+"种方法");
    }
}
