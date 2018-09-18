package Day14;

public interface MyStack {
    void push(String e);//入栈
    String pop();//出栈
    String peek() throws Exception;//访问栈顶元素（不出栈）
    boolean isEmpty();
}
