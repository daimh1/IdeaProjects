package linked;

import Day13.MyLinkedList;

public class MyLinkedStack extends MyLinkedList implements MyStack{
    @Override
    public void push(String e) {
        add(e);
    }

    @Override
    public String pop() {
        return remove( size - 1);
    }

    @Override
    public String peek() {
        if(isEmpty()) {
            throw new EmptyStackException("empty stack");
        }

        return getEnd().data;
    }
}
