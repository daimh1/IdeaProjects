<%@ page import="java.sql.Connection" %>
<%@ page import="Utils.DBCPUtils" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");

    //获取数据
    String username=request.getParameter("username");
    String password=request.getParameter("exampleInputPassword1");
    String age=request.getParameter("age");
    System.out.println(username+password+age);

    //把数据写入数据库
    insert(username,password,age);

    //重定向
    RequestDispatcher rd = request.getRequestDispatcher("/login.html");
    rd.forward(request, response);
%>
<%--注册数据加入数据库--%>
<%!
    private void insert(String username, String password, String age) {
        Connection connection = DBCPUtils.getConnection();
        PreparedStatement preparedStatement=null;

        if(connection!=null){
            try {
                String sql = "insert into user values (?,?,?)";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                preparedStatement.setInt(3, Integer.parseInt(age));

                preparedStatement.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            }finally {
                {
                    if (connection!=null){
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
%>

</body>
</html>
