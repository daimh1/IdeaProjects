package Sorts;
import java.util.Arrays;
import java.util.Random;
public class HeapSortsTest {
    public static int[] inflate(int capacity) {

        int[] array = new int[capacity];

        Random random = new Random();

        for (int i = 0; i < capacity; i++) {
            // [0, 1000)
            array[i] = random.nextInt(1000);
        }

        return array;
    }
    public static void main(String args[]){
        int[] ran=inflate(20);
        HeapSorts heapSorts=new HeapSorts(ran);
        heapSorts.printHeap();
        heapSorts.printHeapGraphic();
        heapSorts.heapSort();
        heapSorts.printHeap();
    }
}
