package bean;

import java.util.List;

public class Course {


    String t_cid ;
    String t_cname;


    //一科课程被多个学生选
    List<Student> students;

    public String getT_cid() {
        return t_cid;
    }

    public void setT_cid(String t_cid) {
        this.t_cid = t_cid;
    }

    public String getT_cname() {
        return t_cname;
    }

    public void setT_cname(String t_cname) {
        this.t_cname = t_cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "t_cid='" + t_cid + '\'' +
                ", t_cname='" + t_cname + '\'' +
                ", students=" + students +
                '}';
    }
}
