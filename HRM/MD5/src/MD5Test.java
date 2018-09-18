import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {

    @Test
    public void test1(){
        String md5 = getMD5("@#dmh");
        String md51 = getMD5(md5);
        String md52 = getMD5(md51);
        System.out.println("md5="+md5);
    }

    public   String getMD5(String pwd){
        String md5hashvalue="";

        try {
            //一个长度可扩展的String
            StringBuffer stringBuffer = new StringBuffer();

            //1、传一个参数：algorithm 算法
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            //2、****MD5值生成算法，传入密码，返回一个MD5字节数组(16位)****
            //这个字节数组长度为16
            byte[] digest = md5.digest(pwd.getBytes());//要先将输入的密码字符串变成字节数组

            //3、对结果进行处理： 将MD5值（16个字节的字节数组）还原成字符串
            for(byte b:digest){
                //从MD5字节数组中一个字节一个字节拿出来，放入StringBuffer中

                //3.1 将byte变为int （一个字节对应一个两位的16进制数）
                //00001110 0E
                int i = b & 0x000000FF;
                //3.2 int转为16进制的字符串（将一个两位数的16进制数 转为 一个字节）
                String s = Integer.toHexString(i);//要求传一个int值
                //3.3 将每个字节对应的字符串一次放入StringBuffer 中
                if(s.length()==1){
                    stringBuffer.append(0);
                }
                stringBuffer.append(s);
            }
            md5hashvalue = stringBuffer.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //返回一个MD5 hash值
        return md5hashvalue;
    }
}
