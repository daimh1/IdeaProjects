package Communication;

public class Test1 {
    public static void main(String[] args) {
        Container container = new Container();

        Producer producer = new Producer(container);
        Consumer consumer = new Consumer(container);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
