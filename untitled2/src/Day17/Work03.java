package Day17;

import java.io.File;
import java.io.IOException;

public class Work03 {
    static File file=new File("D:\\newDocument");
    public static void main(String args[]) {

        File files[] = new File[10];
        for(int i=1;i<=10;i++){
            files[i-1]=creatFile(i+".jpg");
        }
        modifyName(files);//改名
    }

    public static File creatFile(String fileName) {//创建文件
        //String fileName = "test.txt";
        File f = new File(file, fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
                return f;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return f;
        }
        return null;
    }
    public static void modifyName(File files[]){
        int i=1;
        for(File f:files){
            f.renameTo(new File("D:\\newDocument\\2017-4-15-"+i+".jpg"));
            i++;
        }
    }
}