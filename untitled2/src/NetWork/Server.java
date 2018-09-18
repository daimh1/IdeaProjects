package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server extends Thread {
    private DatagramSocket receiveSocket;
    public final static int SERVER_PORT=4396;
    public Server() throws SocketException {
        receiveSocket=new DatagramSocket(SERVER_PORT);
    }

    @Override
    public void run() {
        byte[] buffer=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
        boolean flag=true;

        while (flag){
            try {
                receiveSocket.receive(datagramPacket);
                byte[] data=datagramPacket.getData();
                int length=datagramPacket.getLength();
                String receiveStr=new String(data,0,length);
                System.out.println("from"+datagramPacket.getAddress() + "/" + datagramPacket.getPort() +":"+receiveStr);
                if("886".equals(receiveStr)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        receiveSocket.close();
    }
}
