package linked;


/*
       成员：
       elements
       front
       rear

       行为：接口指定

       构造方法
 */


import java.util.Arrays;

public class MySquentialQueue implements MyQueue{


    //定义elements数组，存储队列中的元素
    String[] elements;

    //队头的指示变量
    int front;

    //队尾的指示变量
    int rear;

    private final static int DEFAULT_ARRAY_SIZE = 10;

    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE;


    public MySquentialQueue() {
        elements = new String[DEFAULT_ARRAY_SIZE];
        front = 0;
        rear = 0;
    }



    @Override
    public void enQueue(String e) {
        ensureCapapcityInternal(size() + 2);
        //当队列满的时候（队尾和数组长度的余数等于队头），才需要扩容
        //扩容一次长度+2
        //将带插入元素放入队列
        elements[rear] = e;//队尾插入e
        rear = next(rear);//重置队尾指针
    }

    private void ensureCapapcityInternal(int minCapacity) {
        if(next(rear) == front) {
           //当队列满的时候，才需要扩容
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//缩小0.5

        if(newCapacity - oldCapacity < 0) {

            newCapacity = minCapacity;
        }

        if(newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }

        //开始扩容
       // String[] strings = Arrays.copyOf(elements, newCapacity); 用不了

        String[] tmp = new String[newCapacity];

        //在此处使用的
        arrayCopy(elements, front, tmp, size());

        //调整front和rear在新数组中的位置
        front = 0;
        rear = size();

        //elements指向，新的扩容之后的队列
        elements = tmp;
    }

    private void arrayCopy(String[] src, int srcPos, String[] dest, int length) {

        for (int i = srcPos, k = 0; i != rear; i = next(i)) {
            dest[k++] = src[i];
        }

    }

    private int hugeCapacity(int minCapacity) {
        if(minCapacity < 0) {
            throw new OutOfMemoryError();
        }

        return MAX_ARRAY_SIZE;
    }

    private int next(int index) {
        return (index + 1) % elements.length;
    }

    @Override
    public String deQueue() {
        return null;
    }

    @Override
    public String peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return (rear - front + elements.length) %  elements.length;
    }


    @Override
    public String toString() {

        if(size() == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        for (int i = front; i != rear ; i = next(i)) {

            builder.append(elements[i]);

            if(next(i) != rear) {
                builder.append(",");
            }
        }

        builder.append("]");
        return builder.toString();
    }
}
