package jdbc;

import Utils.DBUtils;

import java.sql.*;

public class TeaAndStu {
    public static void main(String[] args){
        String sql="select * from emp";
        String sq2="select teacher.tname,student.sname from student cross join teacher where student.teacher_id=teacher.tid;";
        String sq3="select teacher.tname,count(student.sname) from student cross join teacher where student.teacher_id=teacher.tid and teacher.tid=1;";
        String sq4="select teacher.tname,count(student.sex=\"male\") from student cross join teacher where student.teacher_id=teacher.tid and teacher.tid=1 and student.sex=\"male\";";
        String sq5="select teacher.dirc,count(*) from teacher group by teacher.dirc order by count(*) desc limit 1;";
        String sq6="select teacher.tlevel,count(*) from teacher group by teacher.tlevel;";


        try {
            dosql(sql);
            dosql(sq2);
            dosql(sq3);
            dosql(sq4);
            dosql(sq5);
            dosql(sq6);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void dosql(String sql) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet resultSet=null;

        conn=DBUtils.getConnection();
        st=conn.createStatement();



        resultSet=st.executeQuery(sql);
        while (resultSet.next()) {
            //
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();

            for (int i = 0; i < count; i++) {
                String column = resultSetMetaData.getColumnName(i + 1);
                //int a=resultSetMetaData.getColumnType(i+1);
                //String rs=null;
                Object o = resultSet.getObject(i + 1);


                System.out.print(column + ":" + o+"  ");
            }
            System.out.println();
        }
        DBUtils.realse(resultSet,st,conn);
        //resultSet.next();

        /*ArrayList<Dept> depts=new ArrayList<>();
        ArrayList<Emp> emps=new ArrayList<>();

        while (resultSet.next()){
            Emp emp=new Emp();
            Dept dept=new Dept();
            int empno=resultSet.getInt("empno");
            String ename=resultSet.getString("ename");
            String job=resultSet.getString("job");
            String mgr=resultSet.getString("mgr");
            float sal=resultSet.getFloat("sal");
            int deptno=resultSet.getInt("deptno");


            emp.setDeptno(deptno);
            emp.setEmpno(empno);
            emp.setEname(ename);
            emp.setJob(job);
            emp.setMgr(mgr);
            emp.setSal(sal);

            emps.add(emp);

        }

        //String result="";

        System.out.println(emps);
        DBUtils.realse(resultSet,st,conn);*/
    }
}
