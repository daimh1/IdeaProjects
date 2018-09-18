package linked;

/*
        基于队列的操作
 */


public interface MyQueue {

    //如队列
    void enQueue(String e);


    //出队列
    String deQueue();



    //返回队头元素,但是并不将队头元素出队列
    String peek();


    //判空
    boolean isEmpty();

    //返回队列中所包含的元素个数
    int size();
}
