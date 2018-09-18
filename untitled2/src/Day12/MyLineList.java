package Day12;
//import kotlin.reflect.jvm.internal.impl.util.Check;

import java.util.*;
public class MyLineList implements LineList {
    String[] array;
    int size;
    final static int DAFAULT_ARRAYSIZE = 10;
    final  static int MAX_ARRAYSIZE = Integer.MAX_VALUE;
    public MyLineList() {
        array = new String[DAFAULT_ARRAYSIZE];
        size = 0;
    }
    public MyLineList(int capacity) {
        if(capacity < 0 ) {
            throw new IllegalArgumentException("illegal capacity , capacity = " + capacity);
        }
        if (capacity>10){
            throw new IllegalArgumentException("illegal capacity , capacity = " + capacity);
        }
        array = new String[capacity];
        size = 0;
    }
    public boolean add(String s, int index) {//s插入元素，index插入位置

        grow(size+1);//扩容
        CheckRange(index);
        int moveNum = size  - index;
        if(moveNum != 0) {
            System.arraycopy(array,index, array,index + 1, moveNum);//(原数组，开始位置，目标数组，目标开始位置，复制长度）
        }
        array[index] = s;
        size++;
        return true;
    }

    private void grow(int minCapacity) {//按需扩容
        if (minCapacity - MAX_ARRAYSIZE > 0) {
            throw new OutOfMemoryError();
        }
        array = Arrays.copyOf(array, minCapacity);
    }

    private String outMessage(int index) {
        return "size = " + size + ", index = " + index+"数组越界";
    }

    public String remove(int index) {//删除第index位
        CheckRange(index);
        if(size-1<0){
           throw new OutOfMemoryError();
        }
        int moveNum =  size - index - 1;
        String Value = array[index];
        if(moveNum != 0) {
            System.arraycopy(array, index + 1, array, index, moveNum);
        }
        array[size - 1] = null;
        size--;
        return Value;
    }

    private void CheckRange(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(outMessage(index));
        }
    }

    public void set(int index, String newValue) {//第index位替换成newvalue数组元素
        CheckRange(index);
        array[index] = newValue;
    }

    public int indexOf(String e) {//查找e在哪位
        for (int i = 0; i < size; i++) {
            if(Objects.equals(e, array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if(size==0){return true;}
        else {return false;}
    }

    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if(i != size - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
    public static void main(String args[]){
        MyLineList myLineList=new MyLineList();
        myLineList.add("123",0);
        myLineList.add("abc",0);
        myLineList.add("cdf",0);
        myLineList.remove(1);
        myLineList.set(1,"789");
        System.out.println(myLineList.toString());
        System.out.println(myLineList.indexOf("789"));
        System.out.println(myLineList.isEmpty());
    }
}
