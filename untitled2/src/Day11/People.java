package Day11;

public class People {

    protected int num;
    protected String name;
    protected int age;
    protected double salary;
    protected String identy;
    protected int peopleSum=5;
    protected double salarySum=10000;

    public People(int num, String name, int age) throws ageException,emptyException {
        this.num = num;
        this.name = name;
        this.age = age;
        if(age<18){
            throw new ageException("低年龄异常");
        }
        if (age>60){
            throw new ageException("高年龄异常");
        }
        if(name==""||name==null){
            throw new emptyException("空异常");
        }
    }

    public People(int salary, String identy) throws salaryException {
        this.salary = salary;
        this.identy = identy;
        if(salary<600){
            throw new salaryException("薪资过低异常");
        }
    }

    public void addSalary(double addSalary) throws salaryException {
        if((salary+addSalary)>salarySum){
            throw new salaryException("工资高异常");
        }
    }
    public void minusSalary(double minusSalary) throws salaryException {
        if((salary-minusSalary)<600){
            throw new salaryException("工资低异常");
        }
    }
    public void showTotalSalary() throws salaryException{
        if (salarySum<0){
            throw new salaryException("总工资为0");
        }
        System.out.println("总工资数为："+salarySum);
    }
    public void showTotalEmployee() throws emptyException{
        if(peopleSum<=0){
            throw new emptyException("员工人数为0");
        }
    }
}
