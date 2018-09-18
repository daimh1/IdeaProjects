<%@ page import="java.sql.Connection" %>
<%@ page import="Utils.DBCPUtils" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: dmh
  Date: 2018/7/31
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%!
    private boolean isAdmin(String username,String password){
        boolean flag=false;
        if(username.equals("admin")&&password.equals("1234")){
            flag=true;
        }

        return flag;
    }
    private boolean checkinfo(String username, String password) {
        Connection connection = DBCPUtils.getConnection();
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        boolean flag=false;
        if(connection!=null){
            try {
                String sql="SELECT * FROM user WHERE username = ? AND password = ?";
                statement=connection.prepareStatement(sql);
                statement.setString(1,username);
                statement.setString(2,password);
                System.out.println(sql);
                resultSet=statement.executeQuery();
                while(resultSet.next())  //游标指向下一行;
                {
                    flag=true;
                    break;
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (connection!=null){
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return flag;
    }
%>
<%
    request.setCharacterEncoding("utf-8");


    //获取数据
    String username=request.getParameter("username");
    String password=request.getParameter("exampleInputPassword1");
    System.out.println(username+password);
    response.setContentType("text/html; charset=utf-8");


    response.setContentType("text/html;charset=utf-8");
        /*ArrayList<User> users= (ArrayList<User>) session.getAttribute("user");
        if(users==null){
            users=new ArrayList<>();
        }*/
    //如果session不为空，获取session
    if(session.getAttribute("username")!=null&&session.getAttribute("password")!=null) {
        username = (String) session.getAttribute("username");
        password = (String) session.getAttribute("password");
    }
    //System.out.println(sessionusername+" "+sessionpassword);

    session.setAttribute("username",username);
    session.setAttribute("password",password);

        /*User thisuser=new User();
        thisuser.setUsername(username);
        shoppingCart.add(productByProductId);
        session.setAttribute("shoppingCart",shoppingCart);*/
    if(isAdmin(username,password)){
        session.setAttribute("username","admin");
        session.setAttribute("password","1234");

        RequestDispatcher rd = request.getRequestDispatcher("/Work03/admin.jsp");
        rd.forward(request, response);

        return;
    }

    boolean flag=checkinfo(username,password);
    if(flag){


        out.println("你已登录");
        out.println("<a href=\"delete.jsp\">注销</a>");
    }else {
        out.println("登录失败");
        session.setAttribute("username",null);
        session.setAttribute("password",null);
    }


%>
</body>
</html>
