package com.model;

import com.bean.User;
import com.sun.deploy.net.HttpRequest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.List;

public class UserModel {
    private static File userfile;
    static {
        URL resource = UserModel.class.getClassLoader().getResource("user.xml");
        String path = resource.getPath();
        System.out.println("path=" + path);
        userfile = new File(path);
    }

    //注册后用户数据写入xml
    public static boolean saveUser(User user){

        boolean ret =false;


        SAXReader reader = new SAXReader();
        Document document = null;

        try {
            document=reader.read(userfile);

            Element rootElement=document.getRootElement();

            Element element=rootElement.addElement("user");
            element.setAttributeValue("username",user.getUsername());
            element.setAttributeValue("password",user.getPassword());
            element.setAttributeValue("age",user.getAge());

            OutputFormat format=OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(
                    new FileOutputStream(userfile),format);//输出
            writer.write(document);
            writer.close();

            ret=true;


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //request.getServletContext().getRealPath("/user.xml");

        return ret;
    }

    //登录从xml中找到用户数据
    public static boolean findUserByUsernameAndPassword(String username, String password){
        boolean ret=false;

        SAXReader reader=new SAXReader();
        Document document=null;

        try {
            document=reader.read(userfile);
            Element rootElement=document.getRootElement();
            List<Element> elements=rootElement.elements();
            for(Element e:elements){
                if(e.attributeValue("username").equals(username)&&e.attributeValue("password").equals(password)){
                    ret=true;
                    break;
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            {
            }
        }
        return ret;
    }

    //根据用户名找到名字
    public static User findUserByUserName(String username){
        User user=null;

        SAXReader reader=new SAXReader();
        Document document=null;

        try {
            document=reader.read(userfile);
            Element rootElement=document.getRootElement();
            List<Element> elements=rootElement.elements();
            for (Element e:elements){
                if (e.attributeValue("username").equals(username)){

                    String password = e.attributeValue("password");
                    String age = e.attributeValue("age");

                    user = new User(null,username,password,age);

                    break;
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }


        return user;
    }

}
