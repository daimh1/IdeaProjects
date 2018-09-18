package Day19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
setProperty(String key,String value)等同于Map中的put方法
通过键获取值，getProperty(String key)

        Properties properties=new Properties();
        Set<String> set=properties.stringPropertyNames();
        for (String key:set){
            //遍历set集合并将键值复制给key
        }

 */
public class Demo1 {
    public static void main(String args[]){
        function_1("d:\\c.txt");
    }
    public static void function(){
        Properties properties=new Properties();
        Set<String> set=properties.stringPropertyNames();
        for (String key:set){
            //遍历set集合并将键值复制给key
        }
    }
    public static void function_1(String name){
        Properties properties=new Properties();
        try {
            FileReader fileReader=new FileReader(name);
            properties.load(fileReader);
            fileReader.close();
            System.out.println(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void function_2(){

    }
}
