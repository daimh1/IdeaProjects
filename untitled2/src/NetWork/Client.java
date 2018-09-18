package NetWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client extends Thread {
    private DatagramSocket senderSocket;
    public Client() throws SocketException {

        //初始化socket对象
        senderSocket = new DatagramSocket();

    }

    @Override
    public void run() {
        boolean flag=true;
        BufferedReader bufferedReader=null;
        while (flag){
            bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            String data=null;

            try {
                data=bufferedReader.readLine();
                InetAddress destIp=InetAddress.getByName("172.28.102.209");
                DatagramPacket packet=new DatagramPacket(data.getBytes(),0,data.length(),destIp,4396);
                senderSocket.send(packet);
                if("886".equals(data)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        senderSocket.close();
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
