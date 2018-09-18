package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTest {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hhhhh");
            }
        });
    */
        Future<Integer> future=executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                int sum=0;
                for (int i=0;i<10;i++){
                    sum+=i;
                }
                return sum;
            }
        });
        System.out.println(future);
        System.out.println(future.get());
        System.out.println(future);

    }
}
