package Day13;

import Day12.LineList;

public class MyLinkedList implements LineList {
    public class Node{//创建一个节点类
        public String data;//存放数据
        private Node next;//存放下个位置
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    public int size;
    private Node end;
    protected MyLinkedList(){

    }

    @Override
    public boolean add(String e, int index) {
        checkRange(index);
        Node pre=preNode(index);
        link(pre,e);
        size++;
        return true;
    }
    public boolean add(String e) {
        //checkRange(index);
        //Node pre=preNode(index);
        link(end,e);
        end=end.next;
        size++;
        return true;
    }

    @Override
    public String remove(int index) {
        checkRange(index);
        if(size-1<0){
            throw new OutOfMemoryError();
        }
        Node pre=preNode(index);
        Node th=thisNode(index);
        delete(pre,th);
        size--;
        return null;
    }

    @Override
    public void set(int index, String newValue) {

    }

    @Override
    public int indexOf(String e) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
    public void checkRange(int index){
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(outMessage(index));
        }
    }
    private String outMessage(int index) {
        return "size = " + size + ", index = " + index+"数组越界";
    }
    private Node preNode(int index){//找到指定位置的前驱节点
        if(index==0){
            return null;
        }
        int count =1;
        Node node=head;
        while (count<index){
            node=node.next;
            count++;
        }
        return node;
    }
    private Node thisNode(int index){
        Node node=head;
        int count=0;
        while (count<index){
            node=node.next;
            count++;
        }
        return node;
    }
    private void link(Node pre,String e){
        if(pre==null){
            head=new Node(e,head);
            if(size==0) end=head;
        }else{
            Node newNode=new Node(e,pre.next);
            pre.next=newNode;

            if(newNode.next==null){
                end=newNode;
            }
        }
    }
    private void delete(Node pre,Node th){
        if(pre==null){
            head=th.next;
            if(size==1) end=head;
        }
        pre.next=th.next;
    }
    /*protected class Node{
        private String item;
    }*/
    public Node getEnd(){
        return end;
    }
    //public Node ge
    public static void main(String args[]){

    }
}
