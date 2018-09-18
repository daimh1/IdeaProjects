package IO.Pratice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Practice0202 {
    public static void main(String args[]) throws IOException {
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = reader.readLine()) != null) {
            n=Integer.parseInt(str);
            String names[]=new String[n];
            int[] scores=new int[n];
            int[] ages=new int[n];
            for(int i=0;i<n;i++){
                String line=reader.readLine();
                String[] parts = line.split(" ");
                String name=parts[0];
                int age=Integer.parseInt(parts[1]);
                int score=Integer.parseInt(parts[2]);
                int j=0;
                for(j=i-1;j>=0;j--){
                    if(scores[j]>score){
                        scores[j+1]=scores[j];
                        names[j+1]=names[j];
                        ages[j+1]=ages[j];
                    }
                    else if(scores[j]==score) {
                        if(names[j].compareTo(name)<0){
                            scores[j+1]=scores[j];
                            names[j+1]=names[j];
                            ages[j+1]=ages[j];
                        }else{
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                scores[j+1]=score;
                names[j+1]=name;
                ages[j+1]=age;
            }
            for(int i=0;i<n;i++){
                System.out.println(names[i]+" "+ages[i]+" "+scores[i]);
            }
        }
    }
    /*public static void Insert(String parts[],String name[],int age[],int score[]){

        for(int i=0;i<score.length;i++){
            if(Integer.parseInt(parts[2])<score[i]){

            }
        }

    }*/
}