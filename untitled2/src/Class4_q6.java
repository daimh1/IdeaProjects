public class Class4_q6 {
    public static int[][] array={{1,2,3},{4,5,6}};

    public static int[][] reverse(int[][] array){
        int[][] newarray=new int[array[0].length][array.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                newarray[j][i]=array[i][j];
            }
        }
        return newarray;
    }
    public static void printarray(int[][] array){
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        System.out.println("数组转置前：");
        printarray(array);
        System.out.println("数组转置后：");
        printarray(reverse(array));


    }

}
