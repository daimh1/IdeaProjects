import java.util.*;
public class Class4_q5 {
    public static int array[]={1,2,3,4,5,6,7,8,9};
    public static void insert(int num){
        int newarray[]=new int[array.length+1];
        for(int i=0;i<array.length;i++){
            newarray[i]=array[i];
            if(num<array[i]){
                for(int j=newarray.length-1;j>i;j--){
                    newarray[j]=array[j-1];
                }
                newarray[i]=num;
                break;
            }
        }
        array=newarray;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num=sc.nextInt();
        sc.close();
        insert(num);
        System.out.println("插入数字后数组：");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
