package com.webstore.controller.productServlet;

import com.webstore.bean.Product;
import com.webstore.service.ProductService;
import org.apache.commons.beanutils.BeanUtils;
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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet(name = "addProductServlet",urlPatterns = "/addProduct")
public class addProductServlet extends HttpServlet {
    ProductService service=new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //创建DiskFileItemFactory对象
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //获取web应用的servletContext对象
        ServletContext servletContext=this.getServletConfig().getServletContext();
        //内存临时文件目录
        File repository=(File)servletContext.getAttribute("javax.servlet.context.tempdir");
        //设置临时文件目录
        factory.setRepository(repository);
        //设置缓冲区大小3M
        factory.setSizeThreshold(1024*1024*3);
        //创建ServletFileUpload对象
        ServletFileUpload upload=new ServletFileUpload(factory);
        //上传文件总大小限制100M
        upload.setSizeMax(1024*1024*100);
        //上传文件单个大小限制5M
        upload.setFileSizeMax(1024*1024*5);

        //创建一个Map对象,存放表单数据
        Map<String,String> map = new HashMap<>();

        String saveFileName = null;
        //解析正文的数据
        try {
            List<FileItem> items= null;
            items = upload.parseRequest(request);
            Iterator<FileItem> iter=items.iterator();
            while (iter.hasNext()){
                FileItem item=iter.next();
                if (item.isFormField()){//非上传文件
                    processFormField(item,map);
                }else{
                    try {
                        saveFileName = processUploadedFile(item);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.getWriter().println("上传成功！");

        //将realpath存入map
        map.put("imgurl",saveFileName);
        Product product=new Product();

        try {
            BeanUtils.populate(product,map);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //最后将这个product对象交给service，存入数据库
        Boolean aBoolean = service.addProduct(product);
        if (aBoolean){
                response.getWriter().write("增加成功！");
                response.setHeader("Refresh", "1,url=" + request.getContextPath() + "/admin/product/productlist.jsp");
        }else{
            response.getWriter().write("操作失败！请检查数据输入是否正确！");
            response.setHeader("Refresh", "1,url=" + request.getContextPath() + "/admin/product/productlist.jsp");
        }
        System.out.println(product);
    }

    private String processUploadedFile(FileItem item) throws Exception {
        //System.out.println("lalala,进来啦");
        //单个上传文件的处理，保存文件
        String fieldName=item.getFieldName();
        //System.out.println("fieldName="+fieldName);
        String fileName=item.getName();
        System.out.println("fileName="+fileName);
        String contextTypr=item.getContentType();
        //System.out.println("contextTypr="+contextTypr);
        boolean inMemory = item.isInMemory();
        //System.out.println("inMemory="+inMemory);
        long size = item.getSize();
        //System.out.println("size="+size);


        //获取文件后缀
        String suffix=null;
        String [] split= fileName.split("\\.");
//        System.out.println("array="+Arrays.toString(split));
        if (split!=null){
            suffix=split[split.length-1];
        }
//        System.out.println("suffix="+suffix);
        //用UUID解决可能发生的重名问题
        String uuid=UUID.randomUUID().toString();
        //得到输出文件对象
        String saveFileName="C:\\Users\\dmh\\IdeaProjects\\myweb\\myWebStore\\web\\file\\"+fileName;
        String saveFileName2="C:\\Users\\dmh\\IdeaProjects\\myweb\\out\\artifacts\\myWebStore_war_exploded\\file\\"+fileName;
        //System.out.println("saveFileName="+saveFileName);
        //String realPath=uuid+"."+suffix;
        //System.out.println(realPath);
        //这个realPath就是需要保存的图片的地址imgurl
        //System.out.println("realPath="+realPath);
        File file=new File(saveFileName);
        File file2=new File(saveFileName2);
        //System.out.println(realPath);
        //写入文件存储数据
        item.write(file);
        item.write(file2);
        //传回相对路径
        return fileName;
    }

    private void processFormField(FileItem item, Map<String, String> map) {
        //单个基本表单项的处理
        String name =item.getFieldName();

        String value=null;
        try {
            value=item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //System.out.println(name+":"+value);
        //把键值对存入map
        map.put(name,value);
//        System.out.println(map);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
