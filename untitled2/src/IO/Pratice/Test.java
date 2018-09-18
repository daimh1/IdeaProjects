package IO.Pratice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str;
            while((str=reader.readLine())!=null){
                int count = Integer.parseInt(str);
                int sortType = Integer.parseInt(reader.readLine());

                String[] users = new String[count];
                int[] scores = new int[count];
                for(int i=0;i<count;i++){
                    String line = reader.readLine();
                    String[] parts = line.split(" ");
                    String user = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    if(sortType==0){
                        int j = 0;
                        for(j=i-1;j>=0;j--){
                            if(scores[j]<score){
                                scores[j+1] = scores[j];
                                users[j+1] = users[j];
                            }
                            else{
                                break;
                            }
                        }
                        scores[j+1] = score;
                        users[j+1] = user;
                    }
                    else{
                        int j = 0;
                        for(j=i-1;j>=0;j--){
                            if(scores[j]>score){
                                scores[j+1] = scores[j];
                                users[j+1] = users[j];
                            }
                            else{
                                break;
                            }
                        }
                        scores[j+1] = score;
                        users[j+1] = user;
                    }
                }
                for(int i=0;i<count;i++){
                    System.out.println(users[i]+" "+scores[i]);
                }
            }
        } catch(IOException e){

        }
    }

}