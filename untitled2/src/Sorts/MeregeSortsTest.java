package Sorts;

import java.util.Arrays;
import java.util.Random;

public class MeregeSortsTest {
    public static void main(String args[]){
        MeregeSorts meregeSorts=new MeregeSorts();
        int[] ran=inflate(20);
        int result[]=meregeSorts.meregeSort(ran);
        System.out.println(Arrays.toString(result));
    }
    public static int[] inflate(int capacity) {

        int[] array = new int[capacity];

        Random random = new Random();

        for (int i = 0; i < capacity; i++) {
            // [0, 1000)
            array[i] = random.nextInt(1000);
        }

        return array;
    }
}
