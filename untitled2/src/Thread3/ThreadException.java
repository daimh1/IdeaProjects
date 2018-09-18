package Thread3;

public class ThreadException {
    public static void main(String[] args) {

        //我们可以通过设置UncaughtExceptionHandler对象，让该对象捕获溢出线程的异常
        // callback 回调
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

                // 这个方法，会在日志模块 -》 将这些异常信息，通过流保存到文件中
                //处理溢出线程的异常
                System.out.println("DefaultUncaughtExceptionHandler");

            }
        });

        //在主线程中捕获异常
        CatchThreadException1 catchThreadException = new CatchThreadException1();
        /*catchThreadException.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread t" + e.getMessage());
            }
        });*/


        try{
            //试图在主线程捕获子线程抛出的异常
            catchThreadException.start();
        }catch (Exception e) {
            System.out.println("我捕获到了异常");
        }

    }


}

class CatchThreadException extends Thread {

    @Override
    public void run() {
        //将异常抛出run方法之外，就等价于将该抛出了线程
        throw new RuntimeException("测试抛出线程的异常");
    }
}


class CatchThreadException1 extends Thread {

    @Override
    public void run() {
        //将异常抛出run方法之外，就等价于将该抛出了线程
        throw new RuntimeException("测试抛出线程的异常");
    }
}
