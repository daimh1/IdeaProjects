package com.qq.daimh1;

public class Class2_q3 {
    public static int array[]={1,1,5,6,4,9,8,5,8,9,4};

    public static void once(int array[]){
        int j;

        for(int i=0;i<array.length;i++) {
            j = i + 1;
            boolean judge = false;
            if (j < array.length) {
                while (j != i) {

                    if (array[i] == array[j]) {
                        judge = true;
                    }

                    j++;
                    if (j == array.length) {
                        j = 0;
                    }
                }
                if (judge == false) {
                    System.out.println(array[i]);
                }
            }else{
                j=0;
                while (j != i) {

                    if (array[i] == array[j]) {
                        judge = true;
                    }

                    j++;
                }

            }
        }


    }
    public static void once1(int array[]){
        for(int i=0;i<array.length;i++){
            boolean temp=false;
            for(int j=0;j<array.length;j++){
                if(i!=j){
                    if((array[i]^array[j])==0){
                        temp=true;
                    }
                }
            }
            if (!temp) System.out.println(array[i]);

        }
    }
    public static void main(String args[]){
        once1(array);
    }
}
