package NetWork.TCP.ex1;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket socket=new Socket("127.0.0.1",10086);
        System.out.println("client port = "+socket.getLocalPort());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        OutputStream out=socket.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));

        String s=br.readLine();
        System.out.println("input = "+s);

        bw.write(s);

        bw.newLine();
        bw.flush();

        InputStream in=socket.getInputStream();
        byte[] buf=new byte[1024];
        int len=in.read(buf);
        System.out.println(new String(buf,0,len));

        socket.close();
    }
}
