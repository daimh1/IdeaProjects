package homework03.com.cskaoyan.servlet;

import homework03.com.cskaoyan.service.TransferServcie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransferServlet" ,urlPatterns = "/user/transfer")
public class TransferServlet extends HttpServlet {

    TransferServcie servcie =new TransferServcie();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        response.setContentType("text/html;charset=utf-8");

        String from = request.getParameter("from");

        String to = request.getParameter("to");

        String money = request.getParameter("money");

        boolean ret= false;
        try {
            ret = servcie.transfer(from,to,money);
        } catch ( Exception e) {
            e.printStackTrace();
        }

        if (ret){

            response.getWriter().println("转账成功！");
        }else {

            response.getWriter().println("转账失败！");
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
