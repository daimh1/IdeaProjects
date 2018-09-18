
import java.awt.event.KeyEvent;
import java.util.*;
public class Class4_q3 {
    public static int array[]={34,23,6,7,3,9,5,9};

    public static void main(String args[]){
        //Scanner sc=new Scanner(System.in);
        //if(e.getkeyCode() == KeyEvent.VK_ENTER)
        int max=array[0];
        int maxloc=0;
        int min=array[0];
        int minloc=0;
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
                maxloc=i;
            }
            if(min>array[i]){
                min=array[i];
                minloc=i;
            }
        }

        array[maxloc]=array[0];
        array[minloc]=array[array.length-1];
        array[0]=max;
        array[array.length-1]=min;

        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
