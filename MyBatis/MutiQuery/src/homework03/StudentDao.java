package homework03;

import bean.Student;

public interface StudentDao {

  Student findStudentBySid(String sid);

}
