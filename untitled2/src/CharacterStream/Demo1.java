package CharacterStream;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //编码过程
        String s = "你好";
        byte[] gbks = s.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        //解码， 根据码值-》字符
        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);


        //乱码：
        String s1 = new String(gbks, "utf-8");
        System.out.println(s1);
    }
}
