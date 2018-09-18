package NetWork.TCP.ex2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket=new ServerSocket(1111);//创建服务器端套接字对象
        Socket accept=serverSocket.accept();//等待客户端连接请求
        System.out.println("accept port = "+ accept.getLocalPort());
        InputStream in=accept.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));

        String s=null;
        while ((s=br.readLine())!=null){
            bw.write(s);
            bw.newLine();
            if("end".equals(s)){
                break;
            }
        }
        accept.close();
        serverSocket.close();

    }
}
