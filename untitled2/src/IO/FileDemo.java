package IO;

/*file文件
directory目录
path路径
 */

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String args[]) throws IOException {
        function();
    }
    /*
    File(String pathname)
    c:\\abc\\Demo.java
    File(String parent,String child)父路径+子路径
     */
    public static void function() throws IOException {
        File file=new File("d:\\种子\\2.txt");
        boolean b=file.createNewFile();//不能创建文件夹
        System.out.println(b);
    }
    //public static void
}
