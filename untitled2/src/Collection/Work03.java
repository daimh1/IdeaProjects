package Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.Set;

public class Work03 {
    static int nums[]={2,7,11,15};
    static int target=9;
    public static int[] result(int nums[],int target){
        Map<Integer,Integer> map=new HashMap<>();
        int Result[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int releventNums=target-nums[i];
            if(map.containsKey(nums[i])&&map.get(nums[i])!=i){//如果map内包含所求元素，且所求元素不为它本身
                Result[0]=map.get(nums[i]);
                Result[1]=i;
                break;
            }
            map.put(releventNums,i);
        }
        return Result;
    }
    public static void main(String args[]){

        //System.out.println( result(nums,target).toString());
        System.out.println(Arrays.toString(result(nums,target)));
    }

}
