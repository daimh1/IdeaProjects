package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Demo1 {
    public static void main(String args[]) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        ArrayList<Book> books=new ArrayList<Book>();

        //获取工厂示例
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        //如何获取build
        DocumentBuilder builder=factory.newDocumentBuilder();

        File file=new File("src\\xml\\xmldoc\\book.xml");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        Document document=builder.parse(file);//parse解析

        System.out.println("document编码:"+document.getXmlEncoding());
        NodeList bookElements=document.getElementsByTagName("书名");
        int length=bookElements.getLength();
        System.out.println("len="+length);
        Node bookitem= bookElements.item(0);
        short nodeType=bookitem.getNodeType();
        System.out.println(nodeType);
        System.out.println();

        String nodeName=bookitem.getNodeName();
        String nodeValue=bookitem.getNodeValue();
        System.out.println("nodename "+nodeName);
        System.out.println("nodevalue "+nodeValue);

        NodeList childNodes=bookitem.getChildNodes();
        System.out.println("childNodes"+childNodes.item(0).getNodeValue());
        Node firstChild = bookitem.getFirstChild();
        System.out.println("firstchild"+firstChild.getNodeValue());
        Node lastChild = bookitem.getLastChild();
        System.out.println("lastChild"+lastChild.getNodeValue());

        Node parentNode=bookitem.getParentNode();
        System.out.println("parentnode "+parentNode.getNodeName());//只有文本和属性节点有value

        String price=document.getElementsByTagName("售价").item(2).getFirstChild().getNodeValue();
        System.out.println("price "+price);

        NodeList booklist=document.getElementsByTagName("书");
        Node item = booklist.item(2).getChildNodes().item(5).getFirstChild();

        System.out.println("nodename"+item.getNodeName());
        System.out.println("售价"+item.getNodeValue());
        item.setNodeValue("RMB100");
        System.out.println(item.getNodeValue());
        Node thirdbook=booklist.item(2);
        Element isbn = document.createElement("ISBN");
        isbn.setTextContent("12312412");
        isbn.setAttribute("press","tsinghua");
        Node pricenode =booklist.item(2).getChildNodes().item(5);
        thirdbook.insertBefore(isbn,pricenode);
        String xmlEncoding = document.getXmlEncoding();


        //把内存的Dom树以xml格式写到文件中

        TransformerFactory tsf = TransformerFactory.newInstance();
        Transformer tsTransformer = tsf.newTransformer();
        tsTransformer.transform(
                new DOMSource(document),
                new StreamResult("books_out.xml"));
        //isbn.removeAttribute("press");
    }
}
