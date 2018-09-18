package com.webstore.utils;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        sendMail("daimh1@qq.com","<a href='http://localhost'>点击激活注册账户</a>");
    }

    public static boolean sendMail(String email,String emailMsg){
        String from="daimh1@163.com";
        String to=email;
        final String username="daimh1@163.com";
        final String password="2023092dmh";

        Properties properties=System.getProperties();

        properties.setProperty("mail.smtp.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.transport.protocol", "smtp");

        Session session=Session.getInstance(properties);

        session.setDebug(true);

        MimeMessage message=new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));

            message.setSubject("webstore注册用户激活");

            message.setContent((emailMsg),"text/html;charset=utf-8");

            Transport transport=session.getTransport();

            transport.connect("smtp.163.com",25, username, password);
            transport.sendMessage(message,new Address[]{new InternetAddress(to)});
            transport.close();
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

    }
}
