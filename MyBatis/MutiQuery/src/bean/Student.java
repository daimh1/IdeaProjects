package bean;

import java.util.List;

public class Student {

    String t_sid;
    String t_sname ;

    //一个学生选了多门课程
    List<Course> courses;

    @Override
    public String toString() {
        return "Student{" +
                "t_sid='" + t_sid + '\'' +
                ", t_sname='" + t_sname + '\'' +
                ", courses=" + courses +
                '}';
    }

    public String getT_sid() {
        return t_sid;
    }

    public void setT_sid(String t_sid) {
        this.t_sid = t_sid;
    }

    public String getT_sname() {
        return t_sname;
    }

    public void setT_sname(String t_sname) {
        this.t_sname = t_sname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
