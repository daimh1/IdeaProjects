package Sorts;

import java.util.Arrays;

public class HeapSorts {//大根堆排序
    int[] elements;
    int size;
    public HeapSorts(int[] target){//数组
        elements=Arrays.copyOf(target,target.length+1);
        System.arraycopy(elements,0,elements,1,target.length);
        size=target.length;

        heapify();
    }

    private void heapify() {
        for(int i=size/2;i>=1;i--){//从第一个非叶子节点开始，依次向下沉
            fixDown(i,size);
        }
    }

    private void fixDown(int index,int size) {
        /*for (int i=2*index;i<=size;i*=2){
            if(i+1<=size&&elements[i+1]>elements[i]){
                i++;//取左右孩子中最大
            }
            if(elements[i]>elements[index]){
               swap(elements,i,index);
               index=i;
            }else {//当孩子不再大于父亲时，循环终止
                break;
            }
        }*/

        //递归写法
        int i=2*index;
        if(i>size){return;}
        if(i+1<=size&&elements[i+1]>elements[i]){
            i++;//取左右孩子中最大
        }
        if(elements[i]>elements[index]){
            swap(elements,i,index);
            fixDown(i,size);
        }else {
            return;
        }
    }

    public void swap(int[] target, int iIndex, int jIndex) {
        int temp=target[iIndex];
        target[iIndex]=target[jIndex];
        target[jIndex]=temp;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public void printHeapGraphic() {

        PrintHeapTree heap = new PrintHeapTree(elements);
        System.out.println(heap.printFancyTree());
    }
    public void heapSort(){
        for (int i=size;i>1;){
            swap(elements,1,i);
            i--;
            fixDown(1,i);
        }
    }

}

class PrintHeapTree {

    int currentSize;

    int[] array;


    public PrintHeapTree(int[] array) {
        super();
        this.currentSize = array.length -1;
        this.array = array;
    }

    public String printFancyTree()
    {
        return printFancyTree(1, "");
    }

    private String printFancyTree(int index, String prefix)
    {
        String outputString = "";

        outputString = prefix + "|__";

        if( index <= currentSize )
        {
            boolean isLeaf = index > currentSize / 2;

            outputString += array[ index ] + "\n";

            String _prefix = prefix;

            if( index % 2 == 0 )
                _prefix += "|  "; // one | and two spaces
            else
                _prefix += "   " ; // three spaces

            if( !isLeaf )
            {
                outputString += printFancyTree( 2*index, _prefix);
                outputString += printFancyTree( 2*index + 1, _prefix);
            }
        }
        else
            outputString += "null\n";

        return outputString;
    }
}
