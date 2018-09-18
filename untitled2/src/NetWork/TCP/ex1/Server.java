package NetWork.TCP.ex1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10086);

        Socket accept=serverSocket.accept();
        System.out.println("accept port = "+accept.getLocalPort());

        InputStream in=accept.getInputStream();

        BufferedReader br=new BufferedReader(new InputStreamReader(in));

        //BufferedWriter bw=new BufferedWriter(new FileWriter("f.txt"));

        //boolean flag=true;
        String s=null;
        s=br.readLine();
        System.out.println(s);

        OutputStream out=accept.getOutputStream();

        out.write(("收到消息: " + s).getBytes());

        accept.close();
        serverSocket.close();

    }
}
