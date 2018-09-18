package com.mytest;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Genreator {

    public void generator() throws Exception{
    List<String> warnings = new ArrayList<String>();
    boolean overwrite = true; //指向逆向工程配置文件
    File configFile = new File("C:\\Users\\dmh\\IdeaProjects\\production_erp\\generator\\config\\generatorConfig.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(configFile);
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator =
            new MyBatisGenerator(config, callback, warnings);

         myBatisGenerator.generate(null);
}

    public static void main(String[] args) throws Exception {
        try {
            Genreator generatorSqlmap = new Genreator();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
