package XML_practice;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Work03 {
    public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        DocumentBuilder builder=factory.newDocumentBuilder();

        File file=new File("exam.xml");
        Document document=builder.parse(file);

        NodeList stuElements=document.getElementsByTagName("student");
        NodeList nameElements=document.getElementsByTagName("name");
        NodeList locElements=document.getElementsByTagName("location");
        NodeList gradeElements=document.getElementsByTagName("grade");
        int length=stuElements.getLength();
        //System.out.println(length);
        Student[] students=new Student[length];

        for(int i=0;i<students.length;i++){
            String name=nameElements.item(i).getFirstChild().getNodeValue();
            String location=locElements.item(i).getFirstChild().getNodeValue();
            String grade=gradeElements.item(i).getFirstChild().getNodeValue();
            int idcard=Integer.parseInt(stuElements.item(i).getAttributes().item(1).getNodeValue());
            int examid=Integer.parseInt(stuElements.item(i).getAttributes().item(0).getNodeValue());
            students[i]=new Student(idcard,examid,name,location,grade);
            //System.out.println(idcard+" "+examid);
            //System.out.println("name "+name+"loc "+location+"grade "+grade);
        }
        for(Student student:students){
            System.out.println(student);
        }
    }
}
