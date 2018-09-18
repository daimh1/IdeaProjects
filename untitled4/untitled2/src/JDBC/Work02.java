package JDBC;

import Utils.DBUtils;

import java.sql.*;
import java.util.Arrays;

public class Work02 {
    public static void main(String[] args) {
        String sql="insert into student values(1,'a',90,100,100);";
        try {
            insertsql(sql,10000);//一次插入70秒，分100次插入36秒，分50次插入50秒
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void insertsql(String sql,int n) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;


        conn = DBUtils.getConnection();
        st = conn.prepareStatement(sql);

        while (n>0){

            st.addBatch();
            n--;
            if(n%50==0){
                int[] ints = st.executeBatch();//把已经装车的送到数据库去执行
                System.out.println("results="+ Arrays.toString(ints));
                st.clearBatch();//清空批处理的缓存
            }
        }
        int[] ints=st.executeBatch();
        System.out.println("result="+Arrays.toString(ints));
        st = conn.prepareStatement(sql);


        //resultSet = st.executeQuery();;

        DBUtils.realse(resultSet, st, conn);
    }

}
