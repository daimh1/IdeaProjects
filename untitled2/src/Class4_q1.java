public class Class4_q1 {
    public static void perfectNum(int num){
         for(int i=1;i<num;i++){
             int count=0;
             for(int k=1;k<=i/2+1;k++){
                 if(i%k==0){
                     count=count+k;
                 }
             }
             if(count==i){
                 System.out.print(i+" ");
             }
         }
    }
    public static void main(String args[]){
        perfectNum(1000);
    }
}
