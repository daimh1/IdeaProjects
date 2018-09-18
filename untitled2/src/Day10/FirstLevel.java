package Day10;

public class FirstLevel implements Cloneable{

    int i;
    int j;
    //String ijk;
    SecondLevel sec;

    public FirstLevel(int i, int j, SecondLevel sec) {
        this.i = i;
        this.j = j;
        this.sec = sec;
        //this.ijk=ijk;
    }
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        FirstLevel firstLevelLevel = (FirstLevel) super.clone();
        firstLevelLevel.sec = (SecondLevel) this.sec.clone();
        return firstLevelLevel;
    }
    private static void copyRealObject() throws CloneNotSupportedException{
        FirstLevel firstLevel=new FirstLevel(1,2,new SecondLevel(3,new ThirdLevel(4)));
        FirstLevel firstLevel1 = (FirstLevel) firstLevel.clone();
        System.out.println(firstLevel);
        System.out.println(firstLevel1);
        System.out.println("firstlevel和firstlevel1的成员变量ijk地址是否相等："+firstLevel.sec.equals(firstLevel1.sec));
        System.out.println(firstLevel.hashCode());
        System.out.println(firstLevel1.hashCode());
        //System.out.println(firstLevel.i==firstLevel1.i);
    }
    public static void main(String args[]) throws CloneNotSupportedException {
        copyRealObject();
    }
}

class SecondLevel implements Cloneable{
    double j;
    ThirdLevel third;
    public SecondLevel(double j, ThirdLevel third) {
        this.j = j;
        this.third = third;
    }
    protected Object clone() throws CloneNotSupportedException {
        SecondLevel secondLevel=(SecondLevel) super.clone();
        secondLevel.third=(ThirdLevel) this.third.clone();
        return secondLevel;
    }

}

class ThirdLevel implements Cloneable{
    int k;
    public ThirdLevel(int k) {
        this.k = k;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}