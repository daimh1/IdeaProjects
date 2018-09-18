package Sorts;

public class MeregeSorts {
    public static int[] meregeSort(int[] target){
        int[] tmp=new int[target.length];
        mergeSort(target, 0, target.length - 1, tmp);
       return tmp;
    }

    private static void mergeSort(int[] target,int start,int end,int[] tmp){
        if(start<end){//当start=end时无需分解
            int mid=(start+end)/2;
            mergeSort(target,start,mid,tmp);
            mergeSort(target,mid+1,end,tmp);
            mergeList(target,start,mid,end,tmp);

        }
    }
    private static void mergeList(int[] target,int start,int mid,int end,int[] tmp){
        int lStart=start;
        int lEnd=mid;
        int rStart=mid+1;
        int rEnd=end;

        int tmpIndex=start;
        while (lStart<=lEnd&&rStart<=rEnd){//左表和右表比较，小的放入归并表，再进一位
            if(target[lStart]<target[rStart]){
                tmp[tmpIndex++]=target[lStart++];
            }else {
                tmp[tmpIndex++]=target[rStart++];
            }
        }
        //剩余元素放入归并表
        while (lStart<=lEnd){
            tmp[tmpIndex++]=target[lStart++];
        }
        while (rStart<=rEnd){
            tmp[tmpIndex++]=target[rStart++];
        }
        for (int i=start;i<=end;i++){
            target[i]=tmp[i];
        }
    }
}

