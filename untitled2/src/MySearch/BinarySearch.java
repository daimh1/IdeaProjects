package MySearch;

public class BinarySearch {
    public static int recursionSearch(int arr[],int key,int low,int high){
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }
        int middle=(low+high)/2;
        if(arr[middle]>key){
            return recursionSearch(arr,key,low,middle-1);
        }else if(arr[middle]<key){
            return recursionSearch(arr,key,middle+1,high);
        }else{
            return middle;
        }
    }
    public static int commonSearch(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int middle;

        if(key<arr[low]||key>arr[high]||low>high){
            return -1;
        }

        while (low<=high){
            middle=(low+high)/2;
            if(arr[middle]>key){
                high=middle-1;
            }else if(arr[middle]<key){
                low=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
