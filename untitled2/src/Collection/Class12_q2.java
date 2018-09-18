package Collection;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Class12_q2 {
    public static void main(String args[]){
        List<Student> school=new LinkedList<>();

        school.add(new Student("zs",10,1,"male"));
        school.add(new Student("ls",11,2,"female"));
        school.add(new Student("ww",12,3,"male"));

        ListIterator<Student> listIterator=school.listIterator();
        while (listIterator.hasNext()){
            Student s=listIterator.next();
            if(s.name.equals("ls")){
                listIterator.remove();
            }
        }
        System.out.println(school);
        System.out.println("----------------------------------------------");
        ListIterator<Student> listIterator1=school.listIterator();
        for(int i=0;i<school.size();i++){
            if(school.get(i).name.equals("ww")){
                school.remove(i);
            }
        }
        System.out.println(school);
    }
}
/*class Student{
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
}*/
