package Sorts;

import java.util.Arrays;

public class QuickSorts {
    int num[];
    public QuickSorts(int[] target){
        num=Arrays.copyOf(target,target.length);
    }
    public void QuickSort(int low,int high) {
        if(low<high) {
            int pivotpos=part(low,high);
            QuickSort(low,pivotpos-1);
            QuickSort(pivotpos+1,high);
        }
    }
    int part(int low,int high) {
        //int low=1;
        //int high=num.length-1;
        int pivot=num[low];
        while(low<high) {
            while(low<high&&num[high]>=pivot) --high;
            num[low]=num[high];
            while(low<high&&num[low]<=pivot) ++low;
            num[high]=num[low];
        }
        num[low]=pivot;
        return low;
    }

}
