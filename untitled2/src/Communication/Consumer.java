package Communication;

public class Consumer implements Runnable{

    Container container;
    public Consumer(Container container){
        this.container=container;
    }
    @Override
    public void run() {
        while (true){
            synchronized (container){
                if(container.isEmpty()){
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    container.notify();
                    Food food=container.getFood();
                    System.out.println("吃包子："+food);
                    container.setEmpty(true);
                }
            }
        }
    }
}
