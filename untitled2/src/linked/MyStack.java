package linked;


/*
        基于栈这种数据结构的操作
 */
public interface MyStack {


    //入栈操作
    void push(String e);

    //出栈操作
    String pop();

    //访问栈顶元素的值，但是并不删除栈顶元素
    String peek();

    //判断栈是否为空
    boolean isEmpty();
}
