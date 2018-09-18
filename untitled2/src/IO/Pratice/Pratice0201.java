package IO.Pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pratice0201 {
    public static void main(String args[]) throws IOException {
        int n;
        int buf[]=new int[100];
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=reader.readLine())!=null){
            int count=Integer.parseInt(str);
            String line=reader.readLine();
            String[] parts = line.split(" ");
            int[] nums=new int[count];
            for(int i=0;i<count;i++){
                nums[i]=Integer.parseInt(parts[i]);
            }
            //int[] nums=Integer.parseInt(parts);
            Arrays.sort(nums);
            for(int i=0;i<count;i++){

                if(i==count-1){
                    System.out.print(nums[i]);
                    return;
                }else {
                    System.out.print(nums[i]+" ");

                }
            }

        }

    }
}
