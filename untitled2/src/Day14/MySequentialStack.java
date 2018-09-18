package Day14;

public class MySequentialStack extends MySequentialList implements MyStack{
    @Override
    public void push(String e) {
        add(e,size);
    }

    @Override
    public String pop() {
        return remove(size-1);
    }

    @Override
    public String peek() throws Exception {
        if(isEmpty()){
            throw new Exception("EMPTY STACK");
        }
        return elementAt(size-1);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
