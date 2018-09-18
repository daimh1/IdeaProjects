package Day11;

public class Class11_q2 {
    private static int[] array = new int[2];
    private static int n = 5;
    public static void main(String[] args) {
        while(true) {
            try {
                setArray(0,n);
                System.out.println(array[n]);
                break;
            } catch(ArrayIndexOutOfBoundsException e) {
                System.err.println(
                        "Caught ArrayIndexOutOfBoundsException");
                e.printStackTrace();
                n--;
            } finally {
                System.out.println("出现异常");
            }
        }
        System.out.println("异常结束");
    }

    public static void setArray(int i,int n){
        array[n]=i;
    }
}
