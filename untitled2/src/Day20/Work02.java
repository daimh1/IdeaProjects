package Day20;

import java.io.*;

public class Work02 {
    public static void main(String args[]){
        File file=new File("D:\\c.txt");
        System.out.println(printCount(file));
        String string=printCount(file);//读取文件内字符转化为字符串
        char chs[]=string.toCharArray();//字符串转化为char数组
        int letternum=0;
        int spacenum=0;
        int numbernum=0;
        int elsenum=0;
        for(char a:chs){//遍历char数组
            if(Character.isLetter(a)){
                letternum++;
            }else if(Character.isSpaceChar(a)){
                spacenum++;
            }else if(Character.isDigit(a)){
                numbernum++;
            }else {
                elsenum++;
            }
        }
        System.out.println("英文字母个数："+letternum);
        System.out.println("空格个数："+spacenum);
        System.out.println("数字个数："+numbernum);
        System.out.println("其它字符个数："+elsenum);

    }
    public static String printCount(File file){
        String abc="";
        StringBuffer stringBuffer = new StringBuffer("");//追加字符串缓冲
        /*try {
            FileReader fileReader=new FileReader(file);
            char[] buf=new char[1024];
            int len=-1;
            while ((len=fileReader.read(buf))!=-1){
                abc=new String(buf,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            //InputStreamReader br=new InputStreamReader(new FileInputStream(file),"utf-16");
            char[] buf=new char[1024];
            int len=-1;
            while ((len=br.read(buf))!=-1){
                stringBuffer.append(new String(buf,0,len));
            }
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        abc=stringBuffer.toString();
        return abc;
    }
}
