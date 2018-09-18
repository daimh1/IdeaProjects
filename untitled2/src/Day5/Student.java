package Day5;

public class Student {
    public int sNo;
    public String sName;
    public String sSex;
    public int sAge;
    public double sJava;

    public Student(int sNo,String sName,String sSex,int sAge,double sJava){
        this.sNo=sNo;
        this.sName=sName;
        this.sSex=sSex;
        this.sAge=sAge;
        this.sJava=sJava;
    }
    public void getNo(){
        System.out.println("获得"+sName+"学号："+sNo);
    }
    public void getName(){
        System.out.println("获得"+sName+"姓名："+sName);
    }
    public void getSex(){
        System.out.println("获得"+sName+"性别："+sSex);
    }
    public void getAge(){
        System.out.println("获得"+sName+"年龄："+sAge);
    }
    public void getJava(){
        System.out.println("获得"+sName+"java课程成绩："+sJava);
    }
    public static double aver(double sJava1,double sJava2,double sJava3,double sJava4,double sJava5){
        return (sJava1+sJava2+sJava3+sJava4+sJava5)/5;
    }
    public static void minAndmax(double sJava1,double sJava2,double sJava3,double sJava4,double sJava5){
        double min=sJava1;
        double max=sJava1;
        if(min<sJava2) min=sJava2;
        if(min<sJava3) min=sJava3;
        if(min<sJava4) min=sJava4;
        if(min<sJava5) min=sJava5;

        if(max>sJava2) max=sJava2;
        if(max>sJava3) max=sJava3;
        if(max>sJava4) max=sJava4;
        if(max>sJava5) max=sJava5;
        System.out.println("最低分是："+min);
        System.out.println("最高分是："+max);
    }
    public static void main(String args[]){
        Student st1=new Student(1,"xiaoming","male",12,80);
        Student st2=new Student(2,"xiaoli","male",13,85);
        Student st3=new Student(3,"xiaowang","female",11,79);
        Student st4=new Student(4,"xiaohua","female",11,90);
        Student st5=new Student(5,"xiaohuang","male",12,92);

        st1.getAge();
        st1.getJava();
        st1.getName();
        st1.getNo();
        st1.getSex();
        System.out.println("JAVA成绩平均分："+aver(st1.sJava,st2.sJava,st3.sJava,st4.sJava,st5.sJava));
        minAndmax(st1.sJava,st2.sJava,st3.sJava,st4.sJava,st5.sJava);
    }

}
