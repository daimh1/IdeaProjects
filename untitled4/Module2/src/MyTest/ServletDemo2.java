package MyTest;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServletDemo2",urlPatterns = "/resp2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        ServletOutputStream outputStream=response.getOutputStream();
        outputStream.write(98);
        byte[] bytes={99,100,100};
        outputStream.write(bytes,1,2);

        String realPath=getServletContext().getRealPath("/aaa/Work04.html");
        FileInputStream fileInputStream=new FileInputStream(new File(realPath));

        byte[] buf=new byte[1024];
        int length=-1;

        while ((length=fileInputStream.read(buf))!=-1){
            outputStream.write(buf,0,length);
        }
        fileInputStream.close();
    }
}
