package com;


import com.bean.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws IOException {

        //一 创建configuration对象
        Configuration configuration=new Configuration();

        //二 设置模板文件所在路径
        File file= new File("");
        String absolutePath=file.getAbsolutePath();

        configuration.setDirectoryForTemplateLoading(file);

        //三 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        //四 加载一个模板，创建一个模板对象
        Template template=configuration.getTemplate("template.ftl");

        //创建一个模板使用的数据集，map对象
        Map<String,Object> map=new HashMap<>();
        map.put("name","zhangsan");

        //POJO
        User user=new User();
        user.setUsername("lisi");
        user.setPassword("123");
        //map.put("user",user);

        User user1=new User();
        user1.setUsername("zhangsan");
        user1.setPassword("123");
        //map.put("user",user);

        ArrayList<User> userArrayList=new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user1);

        map.put("userlist",userArrayList);
        //六 创建一个writer对象
        FileWriter writer=new FileWriter("zhangsan.html");

        //七 输出文件
        try {
            template.process(map,writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        //关闭流
        writer.close();
    }
}
