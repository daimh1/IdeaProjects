package Day9;

import javax.xml.transform.Result;

public class Class9_q2 {
    public static int nums[]={2, 7, 11, 15};
    public result twoSum(int[] nums, int target) {
        int a=0,b=0;
        for(int i=0;i<nums.length-1;i++){
            for(int k=i+1;k<nums.length;k++){
                if(nums[i]+nums[k]==target){
                    a=i;
                    b=k;
                }
            }
        }
        /*int[] result1=new int[2];

        result1[0]=a;
        result1[1]=b;*/
        result r=new result();
        r.setA(a);
        r.setB(b);
        return r;
    }
    public void print(int[] nums){
        for(int i=0;i<nums.length;i++){
        System.out.print(nums[i]+" ");}
    }
    public static void main(String args[]){
        Class9_q2 class9_q2=new Class9_q2();


        //class9_q2.twoSum(nums,9);
        result r=class9_q2.twoSum(nums,9);
        System.out.print("target是9的整数由数组nums的第"+r.getA()+"和"+r.getB());
        System.out.print("位组成");

    }
    class result{
        int a;
        int b;

        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}

