package StreamIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo2 {

    public static void main(String[] args) throws IOException {

        //创建输出流对象

        //1.创建表示目标文件的File类对象
        File file = new File("b.txt");

        //1.创建FileOutputStream对象
        FileOutputStream fos = new FileOutputStream(file);

        //2.向目标文件中写入数据
        fos.write(97);

        //向目标文件中写入一个字节数组
        //byte[] buffer = {98, 99, 100};
        //fos.write(buffer);

        //向目标文件中写入一个字节数组的一部分
        //                   offset
        byte[] bytes = {105, 106, 107,108};

        fos.write(bytes, 1, 3);



    }
}
