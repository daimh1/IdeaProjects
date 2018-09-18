package Test1;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream=request.getInputStream();
        //File file=new File("123.jpg");
        //System.out.println();
        String realPath=getServletContext().getRealPath("/123.jpg");
        System.out.println(realPath);
        File file=new File(realPath);
        FileOutputStream fileOutputStream=new FileOutputStream(file);

        byte[] bytes=new byte[1024];
        int length=-1;
        while ((length=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,length);
        }
        fileOutputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
