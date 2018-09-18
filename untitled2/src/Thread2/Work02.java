package Thread2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Work02 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入下载资源大小：");
        String str1=reader.readLine();
            Download.docsize=Integer.parseInt(str1);

        System.out.println("请输入线程个数：");
        String str2=reader.readLine();
        Download.threadNum=Integer.parseInt(str2);
        for(int i=0;i<Download.threadNum;i++){
            new Download().start();
        }
    }
}
class Download extends Thread{
    static int docsize;
    static int threadNum;
    final static Object EMBRACE_1=new Object();
    static int downloaded=0;

    public void run(){

        try {
            while (docsize-downloaded>=0) {
                TimeUnit.MILLISECONDS.sleep(10);
                synchronized (EMBRACE_1) {

                    if(docsize-downloaded>0) {
                        System.out.println(currentThread().getName() + "已下载：" + downloaded + "M   剩余：" + (docsize - downloaded) + "M");
                        downloaded++;
                    }
                    else if(docsize-downloaded==0){
                        System.out.println(currentThread().getName() + "已下载：" + downloaded + "M   剩余：" + (docsize - downloaded) + "M");
                        System.out.println("下载完成！");
                        downloaded++;

                    }
                }}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void down(){





    }
}
