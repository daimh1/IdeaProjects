package IO.Pratice;

public class Practice0203 {


}
class Date{
    static int monthOfDay[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    int Day;
    int Month;
    int Year;

    public Date(int day, int month, int year) {
        Day = day;
        Month = month;
        Year = year;
    }

    void nextDay(){
        if(isLeapYear(Year)){
            monthOfDay[2]=29;
        }else {
            monthOfDay[2]=28;
        }
        Day++;
        if(Day>monthOfDay[Month]){
            Day=1;
            Month++;
            if(Month>12){
                Month=1;
                Year++;
            }
        }

    }
    boolean isLeapYear(int year){
        if(year==0||year%4==0){
            return true;
        }
        else {
            return false;
        }
    }
}
