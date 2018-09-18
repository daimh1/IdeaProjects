package linked;

import Day14.MySequentialList;

public class MySquentialStack extends MySequentialList implements MyStack{


    //自己写一个栈
    //elments；
    //int top; 栈顶指针 （指向的永远是，表尾元素的下一个位置，top的数值=size）

    @Override
    public void push(String e) {
        add(e, size());
    }

    @Override
    public String pop() {
        return remove(size() - 1);
    }

    @Override
    public String peek() {

        //第一种处理方式
        if(isEmpty()) {
            //当栈空的时候，直接抛出异常
            throw new EmptyStackException("empty stack");
        }

        //当栈中不可能存在一个元素的取值是null时候，当栈为空的时候
        //也可以返回null，来告诉方法调用者，当前的栈是空的
//        if(isEmpty()) {
//            return null;
//        }
        return elementAt(size() - 1);
    }

}
