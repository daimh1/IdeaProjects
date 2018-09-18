package Test1;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "FileuploadServlet",urlPatterns = "/FileuploadServlet")
public class FileuploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory=new DiskFileItemFactory();

        ServletContext servletContext=this.getServletConfig().getServletContext();
        File repository=(File)servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        ServletFileUpload upload=new ServletFileUpload(factory);

        try {
            List<FileItem> items=upload.parseRequest(request);//解析核心代码
            /*for(FileItem fileItem:items){

            }*/

            Iterator<FileItem> iter=items.iterator();
            while (iter.hasNext()){
                FileItem item=iter.next();
                if(item.isFormField()){//如果是基本表单项（除了文件）
                    processFormField(item);
                }else{//如果是文件
                    processUploadedFile(item);
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    private void processFormField(FileItem item) throws UnsupportedEncodingException {
        String name=item.getFieldName();
        String value=item.getString("utf-8");

        System.out.println(name);
        System.out.println(value);
    }
    private void processUploadedFile(FileItem item) throws Exception {
        String fieldName=item.getFieldName();
        String fileName=item.getName();
        System.out.println(fieldName);
        System.out.println(fileName);

        String contentType=item.getContentType();
        System.out.println(contentType);

        boolean isInMemory=item.isInMemory();
        long sizeInBytes=item.getSize();
        //System.out.println(isInMemory);
        //System.out.println(sizeInBytes);

        InputStream inputStream=item.getInputStream();
        String suffix=null;
        String[] split1=fileName.split("\\.");
        //System.out.println(".".toCharArray());
        //System.out.println(split1[0]);
        for(String s:split1){
            System.out.println("s: "+s);
        }
        if(split1!=null){
            suffix=split1[split1.length-1];
        }

        String uuid=UUID.randomUUID().toString();
        String savefileName=uuid+"."+suffix;
        System.out.println("savafileName:"+savefileName);

        String realPath = getServletContext().getRealPath( savefileName); //后缀
        System.out.println(realPath);
        File file = new File(realPath);

        item.write(file);
    }
}
