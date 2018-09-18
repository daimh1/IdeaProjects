package IO;

import java.io.File;

public class FileDemo1 {
    public static void main(String args[]){
        File file=new File("d:\\");
        File[] fileArr=file.listFiles(new MyFilter());
        for (File f:fileArr){
            System.out.println(f);
        }
    }
}
