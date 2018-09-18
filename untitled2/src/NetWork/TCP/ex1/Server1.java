package NetWork.TCP.ex1;

/*
        Server端的代码：

        ServerSocket
        此类实现服务器套接字。服务器套接字等待请求通过网络传入,和请求端建立连接

        ServerSocket(int port)  //端口号，表示ServerSocket自己所绑定的端口号
          创建绑定到特定端口的服务器套接字。

        public Socket accept()
              throws IOException侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。


        java.net.BindException: Address already in use 一旦一个socket对象绑定了某个端口，
        那么这个端口就不能，再被其socket对象绑定

 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {

        //1.创建服务器端套接字对象
        ServerSocket serverSocket = new ServerSocket(10086);

        //2.等待客户端的连接请求,并和客户端建立连接,此方法在连接传入之前一直阻塞
        //  真正和客户端的socket建立连接的就是accept方法返回的Socket对象
        Socket accept = serverSocket.accept();
        System.out.println("accept port = " + accept.getLocalPort());  //和ServerSocket的端口号是一样的
        //3. 从Socket对象中，取输入流，接收客户端发送的数据
        InputStream in = accept.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));


        boolean flag = true;
        String s = null;
        ////阻塞方法
        s = br.readLine();
        System.out.println(s);

        //发送给客户端反馈信息
        OutputStream out = accept.getOutputStream();

        out.write(("收到消息: " + s).getBytes());


        //关闭socket
        accept.close();  // 关闭服务器端建立连接的普通Socket对象
        serverSocket.close(); //关闭服务器端，用来侦听连接请求，并建立连接的ServerSocket对象


    }
}
