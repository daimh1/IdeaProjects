package XML_practice;

public class Student {
    int idcard;
    int examid;
    String name;
    String loation;
    String grade;

    public Student(int idcard, int examid, String name, String loation, String grade) {
        this.idcard = idcard;
        this.examid = examid;
        this.name = name;
        this.loation = loation;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idcard=" + idcard +
                ", examid=" + examid +
                ", name='" + name + '\'' +
                ", loation='" + loation + '\'' +
                ", grade=" + grade +
                '}';
    }
}
