public class Class4_q2 {
    public static void collectMoney(double num){
        double countmoney=0;
        int day=0;
        while(countmoney<num){
            countmoney+=2.5;
            day++;
            if(day%5==0) countmoney-=6;
        }
        System.out.println("第"+day+"天能存够"+num);
    }
    public static void main(String args[]){
        collectMoney(100);
    }
}
