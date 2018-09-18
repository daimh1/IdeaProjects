package Day20;

import java.io.*;

public class Work04 {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        writeObject();
        readObject();
    }


    public static void writeObject() throws IOException {//序列化
        FileOutputStream fos=new FileOutputStream("d:\\f.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        Cat cat=new Cat("xiaoming",2,"yellow","female");
        oos.writeObject(cat);
        oos.close();
    }
    public static void readObject() throws IOException, ClassNotFoundException {//反序列化
        FileInputStream fis=new FileInputStream("d:\\f.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Object obj=ois.readObject();
        System.out.println(obj);
        ois.close();
    }
}
class Cat implements Serializable {
    public String name;
    public int age;
    public String color;
    public transient String sex;

    public Cat(String name, int age, String color,String sex) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.sex=sex;
    }
    public Cat(){}

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}