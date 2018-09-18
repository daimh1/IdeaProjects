package Day19;

import java.io.FileWriter;
import java.io.IOException;

public class Demo2 {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:\\1.txt");

        //写1个字符
        fw.write(100);
        fw.flush();

        //写1个字符数组
        char[] c = {'a','b','c','d','e'};
        fw.write(c);
        fw.flush();

        //写字符数组一部分
        fw.write(c, 2, 2);
        fw.flush();

        //写如字符串
        fw.write("hello");
        //fw.flush();

        //fw.close();
    }
}