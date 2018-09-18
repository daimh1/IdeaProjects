package linked;

/*

        在java语言中，最基本的代码复用方式有两种：
        1. 继承
        2. 组合(组合这种代码复用的技术)
 */

import Day14.MyLinearList;
import Day14.MySequentialList;

public class MyStack1 implements MyStack{

    //利用组合技术
    MyLinearList stack;

    public MyStack1(MySequentialList stack) {
        this.stack = stack;
    }

    @Override
    public void push(String e) {
        stack.add(e, stack.size());
    }

    @Override
    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public String peek() {
        return null;
    }

//    @Override
//    public String peek() {
//        return stack.elememtAt(stack.size() - 1);
//    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void setStack(MyLinearList stack) {
        this.stack = stack;
    }


    public void copy(MyLinearList a) {
        int size = stack.size();
        for (int i = 0; i < stack.size(); i++) {
            a.add(stack.remove(0), a.size());
        }
    }
}
