package Test;

import Utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

@WebServlet(name = "TransferServlet",urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String from=request.getParameter("from");
        String to=request.getParameter("to");
        String money=request.getParameter("money");
        System.out.println(from+" "+to+" "+money);
        boolean ret=transfer(from,to,money);

        if(ret){
            response.getWriter().println("转账成功！");
        }else {
            response.getWriter().println("转账失败！");
        }
    }

    private boolean transfer(String from, String to, String money) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        boolean flag=false;
        Savepoint savepoint=null;
        connection=DBUtils.getConnection();
        try {
            //connection.setAutoCommit(false);
            String sql_sub="update account set money= money- ? where id = ?";
            preparedStatement=connection.prepareStatement(sql_sub);
            preparedStatement.setInt(1,Integer.getInteger(money));
            preparedStatement.setInt(2,Integer.parseInt(from));
            System.out.println(sql_sub);
            int ret1=preparedStatement.executeUpdate();
            System.out.println("ret1 "+ret1);


            String sql_add="update account set money= money+ ? where id = ?";
            preparedStatement= connection.prepareStatement(sql_add);
            preparedStatement.setInt(1,Integer.parseInt(money));
            preparedStatement.setInt(2,Integer.parseInt(to));
            int ret2 = preparedStatement.executeUpdate();
            System.out.println("ret2="+ret2);

            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.realse(null,preparedStatement,connection);
        }



        return flag;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
