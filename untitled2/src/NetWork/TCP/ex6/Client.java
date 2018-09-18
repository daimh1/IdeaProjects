package NetWork.TCP.ex6;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket socket=new Socket("127.0.0.1",11111);
        System.out.println("client port="+socket.getLocalPort());
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("b.txt"));

        OutputStream outputStream=socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);

        boolean flag=true;
        int len=-1;
        byte[] buf=new byte[1024];
        while ((len=bufferedInputStream.read(buf))!=-1){
            bufferedOutputStream.write(buf,0,len);
        }
        bufferedOutputStream.flush();

        socket.shutdownOutput();

        InputStream inputStream=socket.getInputStream();

        len=inputStream.read(buf);
        System.out.println("反馈："+new String(buf,0,len));
        socket.close();

        //BufferedInputStream
    }
}
