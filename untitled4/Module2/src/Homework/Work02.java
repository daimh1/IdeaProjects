package Homework;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "Work02",urlPatterns = "/Work02")
public class Work02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().print("123");
        ServletOutputStream outputStream=response.getOutputStream();
        String filename1=request.getParameter("file");
        String filename=new String(filename1.getBytes(),"ISO-8859-1");
        response.setHeader("Content-Disposition","attachment; filename="+ filename);
        String realPath = getServletContext().getRealPath("/"+filename1);
        FileInputStream fileInputStream = new FileInputStream(new File(realPath));

        byte[] buf=new byte[1024];
        int length=-1;

        while ((length=fileInputStream.read(buf))!=-1){

            outputStream.write(buf,0,length);
        }


        fileInputStream.close();
    }
}
