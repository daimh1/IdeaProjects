package com.qq.daimh1;

public class Abstractcl {
}

abstract class AbsMyList{
    protected  int len = 0;
    protected AbsMyList(){

    }
    abstract public boolean add(Object o);
    abstract public Object getElement(int index);
    abstract public boolean isElement(Object o);
    abstract int indexOf(Object o);
    abstract public boolean deleteElement(Object o);
    abstract public void clear();
    public int len(){
        return this.len;
    }
    public boolean isEmpty(){
        return this.len==0;
    }
}
interface  ImpQueue{
    void inQueue(String o);
    Object outQueue();
    boolean isEmpty();
}
interface ImpStack{
    void  push(Object o);
    Object pop();
    boolean isEmpty();
}

