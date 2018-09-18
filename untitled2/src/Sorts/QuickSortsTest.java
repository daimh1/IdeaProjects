package Sorts;

import java.util.Arrays;
import java.util.Random;

public class QuickSortsTest {
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
        QuickSorts quickSorts=new QuickSorts(ran);
        quickSorts.QuickSort(0,quickSorts.num.length-1);
        System.out.print(Arrays.toString(quickSorts.num));
    }
}
