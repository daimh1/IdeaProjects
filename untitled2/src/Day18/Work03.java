package Day18;

import java.io.*;

public class Work03 {
    public static void main(String args[]) throws IOException {
        File file=new File("c.txt");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getFileNameWithoutSuffix(file)+"_copy"+getFileSuffix(file)));
        byte[] buffer = new byte[2048];

        int len = -1;
        while((len = bufferedInputStream.read(buffer)) != -1) {

            bufferedOutputStream.write(buffer, 0, len);

        }

        //释放上层包装流资源（包装流会自己去释放底层依赖的普通流）
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    public static String getFileNameWithoutSuffix(File file){
        String file_name = file.getName();
        return file_name.substring(0, file_name.lastIndexOf("."));

    }
    public static String getFileSuffix(File file){
        String file_name = file.getName();
        return file_name.substring(file_name.lastIndexOf(".")-1,file_name.length());
    }
}
