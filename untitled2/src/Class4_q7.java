public class Class4_q7 {
    public static int[][] array1={{1,2},{3,4},{5,6},{7,8}};
    public static int[][] array2={{1,2,3},{4,5,6}};
    public static int[][] resultarray;
    public static void mul(int[][] array1,int[][] array2,int[][] resultarray){
        if(array1[0].length!=array2.length){
            System.out.print(false);
            return;
        }
        resultarray=new int[array1.length][array2[0].length];
        for(int i=0;i<resultarray.length;i++){
            for(int j=0;j<resultarray[i].length;j++){
               int temp=0;
               for(int k=0;k<array2.length;k++){
                   temp=temp+array1[i][k]*array2[k][j];
               }
               resultarray[i][j]=temp;
               System.out.print(resultarray[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        mul(array1,array2,resultarray);
        //System.out.print(resultarray[1][0]);
        //printarray(resultarray);
    }
}
