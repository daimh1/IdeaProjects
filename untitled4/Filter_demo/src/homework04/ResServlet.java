package homework04;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ResServlet",urlPatterns = "/res")
public class ResServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取数据
        String username=request.getParameter("username");
        String password=request.getParameter("exampleInputPassword1");
        String age=request.getParameter("age");

        SAXReader reader=new SAXReader();
        try {
            String string = ResServlet.class.getClassLoader().getResource(".").getPath();
            System.out.println(string);
            Document document=reader.read(string+"user.xml");
            Element root=document.getRootElement();
            List<Element> elements=root.elements();
            System.out.println(elements.size());

            Element node=root.addElement("user");
            node.addAttribute("username",username);
            node.addAttribute("password",password);
            node.addAttribute("age",age);

            /*OutputFormat format=OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");*/
            XMLWriter writer = new XMLWriter(
                    new FileOutputStream("C:\\Users\\dmh\\IdeaProjects\\untitled4\\Filter_demo\\src\\user.xml"),OutputFormat.createPrettyPrint());//输出
            writer.write(document);
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/Work04/login.html");
        rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
