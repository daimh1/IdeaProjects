package Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class Work02 {//不允许存储重复对象，存取快，线程不安全
    public static void main(String args[]){
        Set<Student> b = new HashSet<>();

        //e.hash == hash && ((k = e.key) == key || key.equals(k)
        b.add(new Student("zs",18,1,"male"));
        b.add(new Student("zs",18,1,"male"));
        System.out.println(b);

        //HashMap<Integer, String> c = new HashMap<>();
    }

}
class Student{
    String name;
    int age;
    int ID;
    String sex;

    public Student(String name, int age, int ID, String sex) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Student)) return false;
        Student student=(Student) obj;
        return age==student.age&&ID==student.ID&&Objects.equals(name,student.name)&&Objects.equals(sex,student.sex);
    }

    public int hashCode(){
        return Objects.hash(name,age,ID,sex);
    }
}
