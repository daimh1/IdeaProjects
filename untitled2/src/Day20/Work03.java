package Day20;

import java.io.*;
import java.util.Arrays;

public class Work03 {
    public static void main(String args[]){
        File file=new File("D://e.txt");
        String txt="123 3342 454 1231 4543 2131 34234 565 787 445";
        writeIn(txt,file);//写入数据
        String readtxt=readTxt(file);//读出文件内的数据
        //System.out.println(readtxt);
        String[] parts=readtxt.split(" ");//分隔数字
        int[] nums=new int[parts.length];
        int i=0;
        for(String p:parts){
            nums[i]=Integer.parseInt(parts[i]);//将string数组转成数字
            i++;
        }
        Arrays.sort(nums);//排序
        StringBuffer resultbuffer=new StringBuffer("");
        for(int num:nums){//将数组转成字符串
            resultbuffer.append(num+" ");
        }
        String result1=resultbuffer.toString();
        //System.out.println(result1);
        try {
            OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(file,true));
            osw.write("\r\n"+result1);
            osw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void writeIn(String str,File file){
        try {
            OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(file));
            osw.write(str);
            osw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readTxt(File file){
        String result="";
        try {
            InputStreamReader isr=new InputStreamReader(new FileInputStream(file));
            char[] buffer=new char[1024];
            int len=-1;
            while ((len=isr.read(buffer))!=-1){
                result=new String(buffer,0,len);
            }
            isr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
