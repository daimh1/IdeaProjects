package Day4;

public class Class6_q2 {
    public static int array[][][]=new int[3][4][5];
    public static void ins(int array[][][]){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                for(int k=0;k<array[i][j].length;k++){
                    array[i][j][k]=i+j+k;
                }
            }
        }
    }
    public static void print(int array[][][]){
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[i].length;j++) {
                for(int k=0;k<array[i][j].length;k++){
                    System.out.print(array[i][j][k]);
                }
                System.out.println();//二维换行
            }
            System.out.println();//三维换行
        }
    }
    public static void main(String args[]){
        ins(array);
        print(array);
    }
}
