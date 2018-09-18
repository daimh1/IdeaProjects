package NetWork.TCP.ex6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket=new ServerSocket(11111);
        Socket accept=serverSocket.accept();
        System.out.println("accept port="+accept.getLocalPort());
        InputStream inputStream=accept.getInputStream();
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("s.txt"));
        byte[] buf=new byte[1024];
        int len=-1;
        while ((len=bufferedInputStream.read(buf))!=-1){
            bufferedOutputStream.write(buf,0,len);
        }
        bufferedOutputStream.flush();

        OutputStream outputStream=accept.getOutputStream();
        outputStream.write("文件上传完毕".getBytes());
        accept.close();
        serverSocket.close();
        bufferedOutputStream.close();
    }
}
