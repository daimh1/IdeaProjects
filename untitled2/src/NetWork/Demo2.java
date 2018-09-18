package NetWork;

import java.io.IOException;
import java.net.*;

public class Demo2 {
    public static void main(String args[]){
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            String a="hello world.";
            //创建目的端的ip地址的对象
            InetAddress local=InetAddress.getByName("localhost");
            //将发送数据放入数据包中
            DatagramPacket packet=new DatagramPacket(a.getBytes(),0,a.length(),local,10088);
            datagramSocket.send(packet);
            datagramSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
