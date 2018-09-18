package linked;

public class Test {

    public static void main(String[] args) {

        MySquentialQueue mySquentialQueue = new MySquentialQueue();

        for (int i = 0; i < 7; i++) {
            mySquentialQueue.enQueue(i+"");
        }
        System.out.println(mySquentialQueue);

        for (int i = 100; i < 105; i++) {
            mySquentialQueue.enQueue(i + "");
        }
        System.out.println(mySquentialQueue);
    }
}
