package Day10;

public class Class10_q3 {
    static int arr[]={1,2,3};
    static String s="abc";
    static String bigstr="woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
    public static void sub(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(i==0){
                System.out.print("["+arr[i]+",");
            }
            else if(i==arr.length-1){
                System.out.print(arr[i]+"]");
            }
            else{
                System.out.print(arr[i]+",");
            }
        }
        System.out.println();
    }
    public static String Reverse(String s)
    {
        char[] array = s.toCharArray(); //将string类型参数转化为char[]类型参数
        String reverse = "";  //注意这是空串，不是null
        for (int i = array.length - 1; i >= 0; i--)
            reverse += array[i];
        return reverse;
    }
    public static int smallstrCount(String bigstr,String smallstr){
        int count=0;
        int sstrLength=smallstr.length();
        while(bigstr.indexOf(smallstr)!=-1){
            count++;
            bigstr=bigstr.substring(bigstr.indexOf(smallstr)+sstrLength);
        }
        return count;
    }
    public static void main(String args[]){
        sub(arr);
        System.out.println(Reverse(s));
        System.out.println(smallstrCount(bigstr,"java"));
    }
}
