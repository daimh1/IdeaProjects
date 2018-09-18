package NetWork.TCP.ex2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket socket=new Socket("127.0.0.1",1111);
        System.out.println("client port="+socket.getLocalPort());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream=socket.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));

        while (true){
            String s=br.readLine();
            System.out.println("input = "+s);

            bw.write(s);
            bw.newLine();
            bw.flush();
            if("end".equals(s)){
                break;
            }

            InputStream inputStream=socket.getInputStream();
            byte[] buf=new byte[1024];
            int len=inputStream.read(buf);
            System.out.println(new String(buf,0,len));
        }

        socket.close();
    }
}
