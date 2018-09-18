package NetWork;

import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chart {
    public static void main(String[] args) throws SocketException {

        //启动发送数据和接收数据的线程
        Client client = new Client();
        Server server = new Server();
//
        client.start();
        server.start();
        //线程池
        /*ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(client);
        executorService.submit(server);*/
    }
}
