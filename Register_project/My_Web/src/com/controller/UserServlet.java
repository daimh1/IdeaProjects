package com.controller;

import com.bean.User;
import com.dao.daoUtils.DaoSQL;
import com.model.UserModel;
import com.service.UserService;
import com.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String op = request.getParameter("op");

        if (op!=null&&!op.isEmpty()){


            switch (op){

                case "register":
                    register(request,response);
                    break;

                case "login":
                    login(request, response);
                    break;

                case "getInfo":
                    getInfo(request, response);
                    break;

                case "logout":
                    logout(request, response);
                    break;

                case "modi":
                    modi(request,response);
                    break;




            }


        }

        /*String username=request.getParameter("username");
        String password=request.getParameter("password");
        String repass=request.getParameter("repass");
        String age=request.getParameter("age");

        User user=new User(username,password,age);
        boolean ret=UserModel.saveUser(user);

        if(ret){
            response.getWriter().println("注册成功");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/login.jsp");
        }else {
            response.getWriter().println("注册失败");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/register.jsp");
        }


*/
    }



    private void modi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        String a=request.getParameter("my_username");
        String b=request.getParameter("my_password");
        String c=request.getParameter("my_age");
        //System.out.println(a+b+c);
        if(c!=null&&a!=null&&b!=null) {
            String d = null;
            try {
                d = (String) session.getAttribute("session_username");
            } catch (Exception e) {
                response.getWriter().println("修改失败！即将 跳转到首页！");
                response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
                return;
            }
            User user = new User(null,a, b, c);
            DaoSQL dao = new DaoSQL();
            //DaoSQL.deleteUserByUserName(d); //删除
            dao.saveUser(user);//保存新的User

            session.setAttribute("session_username", a);
            session.setAttribute("session_password", b);
            session.setAttribute("session_age", c);
            session.setAttribute("session_user", user);
            response.getWriter().println("修改成功！即将 跳转到首页！");


            response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
        }else {
            response.getWriter().println("输入元素为空！即将 跳转到首页！");
            response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
        }

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {


        HttpSession session = request.getSession(false);
        if (session!=null){
            session.invalidate();
            response.getWriter().println("注销成功！即将 跳转到首页！");
        }
        response.setHeader("refresh","3;url="+request.getContextPath()+"/index.jsp");


    }

    private void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("regAdmin"));
        if (session.getAttribute("regAdmin").equals("abc")){
            //session.setAttribute("queryResult",DaoSQL.findAllUser());
            request.getRequestDispatcher("/admin.jsp").forward(request,response);

            //String username = (String) session.getAttribute("username");

            //User user= DaoSQL.findUserByUserName(username);




                //request.setAttribute("user",user);



//                response.getWriter().println("用户不存在，发生异常！请先登录！即将跳转到登录页面");
//                response.setHeader("refresh","3;url="+request.getContextPath()+"/login.jsp");




        }


    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("exampleInputPassword1");


        boolean exist= userService.login(username,password);
        if (exist){ //用户存在

            User user=null;//=DaoSQL.findUserByUserName(username);
            //会话管理
            HttpSession session = request.getSession();
            session.setAttribute("session_user",user);
            session.setAttribute("session_username",user.getUsername());
            session.setAttribute("session_password",user.getPassword());
            session.setAttribute("session_age",user.getAge());



            response.getWriter().println("登录成功！即将跳转到首页页面");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/index.jsp");

        }else{
            response.getWriter().println("登录失败！请重新登录！");
            response.setHeader("refresh","3;url="+request.getContextPath()+"/login.jsp");
        }
    }
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //注册，最终把用户注册信息保存起来
        //第一种，是需要保存到数据库
        //第二种，保存到xml里

        //serlve里可以把用户请求的信息获取到
        //直接跟request 打交道的，不能给servcie做
        String username = request.getParameter("username");
        String password = request.getParameter("exampleInputPassword1");
        String repass = request.getParameter("exampleInputPassword2");
        String age = request.getParameter("age");

        HttpSession session=request.getSession();

        //判断两次密码是否一致

        if(!password.equals(repass)){

        }
        //参数的合法性检查（控制器）

        User user = new User(null,username, password, age);

        int ret = userService.register(user);

        if (ret == 1) {

            response.getWriter().println("注册成功！即将跳转到首页");
            response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
            session.setAttribute("session_username", username);
            session.setAttribute("session_password", password);
            session.setAttribute("session_age", age);
            session.setAttribute("session_user", user);

        } else if (ret == -1) {

            response.getWriter().println("该用户名已经被占用了！请重新注册！");
            response.setHeader("refresh", "3;url=" + request.getContextPath() + "/register.jsp");

        } else if (ret == -2) {
            response.getWriter().println("注册失败！请重新注册！");
            response.setHeader("refresh", "3;url=" + request.getContextPath() + "/register.jsp");


        }
    }
}
