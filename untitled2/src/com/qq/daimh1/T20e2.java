package com.qq.daimh1;

public class T20e2 {
    public static void main(String args[]){
        ImpQueue myQueue=new LinkedList();
        myQueue.inQueue("\tThankyou");
        //myQueue.inQueue("\tThanks");
        System.out.println("出队");
        while(!myQueue.isEmpty()){
            System.out.println(myQueue.outQueue());
            //myQueue.outQueue();
        }
        ImpStack myStack=new LinkedList();
        System.out.println("\nStack栈中元素出栈情况：");
        //myStack.push("\tabcdefg");
        //myStack.push("\tabcdefg");
        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }
}
class LinkedList extends  AbsMyList implements  ImpQueue,ImpStack {

    private static class InnerMyEntry {
        Object object;
        InnerMyEntry next;
        InnerMyEntry previous;

        InnerMyEntry(Object object, InnerMyEntry next, InnerMyEntry previous) {
            this.object = object;
            this.next = next;
            this.previous = previous;
        }
    }

    private InnerMyEntry header = new InnerMyEntry(null, null, null);

    public LinkedList() {
        this.header.next = this.header.previous = this.header;
    }

    private InnerMyEntry addBefore(Object o, InnerMyEntry e) {
        InnerMyEntry newEntry = new InnerMyEntry(o, e, e.previous);
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        //newEntry=newEntry.next;
        this.len++;
        return newEntry;
    }

    public boolean add(Object o) {
        this.addBefore(o, header);
        return true;
    }

    public void clear() {
        InnerMyEntry e = this.header.next;
        while (e != this.header) {
            InnerMyEntry next = e.next;
            e.next = e.previous = null;
            e.object = null;
            e = next;
        }
        this.header.next = this.header.previous = this.header;
        this.len = 0;
    }

    public boolean isElement(Object o) {
        return this.indexOf(o) != -1;
    }

    public Object getElement(int index) {
        InnerMyEntry myEntry = this.entry(index);
        if (myEntry == null) return null;
        return myEntry.object;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                if (e.object == null){ return index;}
                index++;
            }
        } else {
            for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                if (o.equals(e.object)){ return index;}
                index++;
            }
        }
        return -1;
    }

    public boolean deleteElement(Object o) {
        if (o == null) {
            for (InnerMyEntry e = header.next; e != header; e = e.next) {
                if (e.object == null) {
                    return false;
                }
            }
        } else {
            for (InnerMyEntry e = header.next; e != header; e = e.next) {
                if (o.equals(e.object)) {
                    e.previous.next = e.next;
                    e.next.previous=e.previous;
                    //e.next = e.previous = null;
                    e.object = null;

                }
            }
        }
        return false;
    }
    public Object outQueue(){
        Object result=this.header.next.object;
        this.deleteElement(this.header.next);
        return result;
    }
    public void inQueue(String o){
        this.addBefore(o,header);
    }

    @Override
    public Object pop() {
        Object result=this.header.previous.object;
        this.deleteElement(this.header.previous);
        return result;
    }

    @Override
    public void push(Object o) {
        this.addBefore(o,header);
    }
    private  boolean deletElement(InnerMyEntry e){
        if(e==header){
            return false;
        }
        e.previous.next=e.next;
        e.next.previous=e.previous;
        e.next=e.previous=null;
        e.object=null;
        this.len--;
        return true;
    }

    private InnerMyEntry entry(int index) {
        if (index < 0 || index >= this.len) {
            return null;
        }
        InnerMyEntry e = header;
        if (index < (this.len >> 1)) {
            for (int i = 0; i <= index; i++) {
                e = e.next;
            }
        } else {
            for (int i = this.len; i > index; i++) {
                e = e.previous;
            }

        }
        return e;
    }
}