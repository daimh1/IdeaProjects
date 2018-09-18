package Day11;

public class Class11_q4 {
    private static int[] array = new int[2];
    private static int n = 5;
    public static void main(String[] args) {
        //int b=20;
        while(true) {
            try {
                setArray(0,n);
                System.out.println(array[n]);
                return;
            } catch(ArrayIndexOutOfBoundsException e) {
                System.err.println(
                        "Caught ArrayIndexOutOfBoundsException");
                e.printStackTrace();
                n--;
            } finally {
                System.out.println("出现异常");
                //return;
            }
            //return;
        }
        //System.out.println("异常结束");
    }
//会执行，在方法return动作之前，return语句执行之后，若finally中再有return语句，则此方法以finally的return作为最终返回，若finally中无return语句，则此方法以try的return作为最终返回
    public static void setArray(int i,int n){
        array[n]=i;
    }
}
