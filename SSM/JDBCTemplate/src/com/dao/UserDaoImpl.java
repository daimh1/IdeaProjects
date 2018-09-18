package com.dao;

import com.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//现在这里要用JDBCTemplate？

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    //JDBCTemplate怎么去查询

   @Autowired
    JdbcTemplate jdbcTemplate=new JdbcTemplate();

    /*{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        jdbcTemplate.setDataSource(comboPooledDataSource);
    }*/

    /*public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Autowired
    public void setAAA(DataSource ds){
        setDataSource(ds);
    }


   /* @Autowired
    public UserDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }*/

    @Override
    public User findUserById(String id) {
        String sql="select * from t_user WHERE ID = ?";
       /* RowMapper<User> rm = ParameterizedBeanPropertyRowMapper.newInstance(User.class);
        User user = (User) this.jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = 1", rm);*/
        //Integer rowCount = this.jdbcTemplate.queryForObject("select * from t_user WHERE ID = ?", Integer.class ,id);
        //List<User> users = this.jdbcTemplate.queryForList("select * from t_user WHERE ID = ?", User.class, id);
       // return null;
        List<User> query = this.getJdbcTemplate().query(sql, new RowMapper<User>() {


            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {

                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                return user;

            }
        }, new Object[]{id});
        return query.get(0);
    }

    @Override
    public boolean add(User user) {
        boolean flag=false;
        String username=user.getUsername();
        String password=user.getPassword();
        String email=user.getEmail();
        String sql="INSERT INTO t_user values(?,?,?,?,null,null);";

        //System.out.println(getJdbcTemplate());

        int count = this.jdbcTemplate.update(sql, user.getId(),username,password,email);
        if(count==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean delete(String id) {
        boolean flag=false;
        String sql="delete from t_user where id =?;";

        //System.out.println(getJdbcTemplate());

        int count = this.jdbcTemplate.update(sql, id);
        if(count==1){
            flag=true;
        }
        return flag;
    }

    @Override
    public boolean updateuser(String id, User user) {
        boolean flag=false;
        String sql="update t_user set username=?,password=?,email=? where id =?;";

        int count = this.jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getEmail(), id);
        if(count==1){
            flag=true;
        }
        return flag;
    }
}
