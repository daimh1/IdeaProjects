package NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {

    public static void main(String args[]){
        try {
            InetAddress inetAddress=InetAddress.getByName ("172.28.102.209");
            System.out.println("hostname = "+inetAddress.getHostName());
            System.out.println("hostAdress = "+inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
