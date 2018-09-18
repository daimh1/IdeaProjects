package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
    public static void main(String args[]) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(10088);
        byte[] buffer=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);

        datagramSocket.receive(datagramPacket);
        byte[] data=datagramPacket.getData();
        int length=datagramPacket.getLength();

        System.out.println(new String(data,0,length));
        datagramSocket.close();

    }

}
