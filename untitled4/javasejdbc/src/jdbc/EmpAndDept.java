package jdbc;

import Utils.DBUtils;
import bean.Dept;
import bean.Emp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;

import java.util.ArrayList;
import java.util.Properties;

public class EmpAndDept {
    public static void main(String[] args){
        String sql="select emp.deptno,max(emp.sal) from emp group by emp.deptno;";
        String sq2="select max(emp.sal) from emp where emp.job=\"CLERK\";";
        String sq3="select emp.deptno,max(emp.sal) from emp group by deptno having max(sal)<2000;\n" +
                "\n";
        String sq4="select emp.ename,emp.deptno,emp.sal from emp order by deptno,sal;";
        String sq5="select * from emp where deptno in(select deptno from emp where ename=\"buddy\");";
        String sq6="select emp.ename,emp.job,emp.deptno,dept.dname from emp cross join dept where emp.deptno=dept.deptno;";
        String sq7="select emp.ename,emp.job,emp.deptno,dept.dname from emp cross join dept where emp.deptno=dept.deptno and emp.job=\"CLERK\";";
        String sq8="select ename,mgr from emp where mgr<>\"\";";
        String sq9="select dept.dname,dept.deptno,emp.ename,emp.job from dept cross join emp where emp.job=\"clerk\";";
        String sq10="select deptno,ename,sal from emp  where emp.sal<(select avg(sal) from emp);";
        String sq11="select count(*),deptno from emp where emp.sal>(select avg(sal) from emp)  group by deptno order by deptno;";


        try {
            dosql(sql);
            dosql(sq2);
            dosql(sq3);
            dosql(sq4);
            dosql(sq5);
            dosql(sq6);
            dosql(sq7);
            dosql(sq8);
            dosql(sq9);
            dosql(sq10);
            dosql(sq11);



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void dosql(String sql) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet resultSet=null;

        conn=DBUtils.getConnection();
        st=conn.prepareStatement(sql);



        resultSet=st.executeQuery();
        //resultSet=st.getResultSet();
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
