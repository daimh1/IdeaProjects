package NetWork.TCP.ex1;

/*
        tcp网络编程客户端
        1. 创建tcp客户端(发送端)的socket对象
        Socket：此类实现客户端套接字（也可以就叫“套接字”）。

          Socket(String host, int port)  ip和端口号表示要连接的对端的ip地址和端口号
          创建一个流套接字并将其连接到指定主机上的指定端口号。
        2. 利用socket对象中的流，传输数据
        3. 数据传输完毕，关闭socket

        //java.net.ConnectException: Connection refused,必须先成功和服务器端建立连接，才能传输数据


 */

import java.io.*;
import java.net.Socket;

public class Client1 {

    public static void main(String[] args) throws IOException {
        //1. 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 10086);

        System.out.println("client port = " + socket.getLocalPort());

        //键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OutputStream out = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));


        String s = br.readLine();
        System.out.println("input = " + s);

        //2.利用已经建立连接的socket对象中的流，来传输数据

        bw.write(s);
        //不要忘记，一次写入一行数据时不要忘了加换行符
        bw.newLine();
        bw.flush();


        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];

        int len = in.read(buf);
        System.out.println(new String(buf, 0, len));


        //3.释放socket资源
        socket.close();  //关闭socket对象的时候，socket会自动释放，其中的流


    }
}
