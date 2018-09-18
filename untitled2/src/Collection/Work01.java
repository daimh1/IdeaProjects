package Collection;

import java.util.*;

public class Work01 {
    public static void main(String[] args) {
        Collection<Person> c = new ArrayList<>();

        c.add(new Person("zs", 18));
        c.add(new Person("lisi", 19));
        c.add(new Person("zs", 18));

        //试下是否能删除已经存储的集合c中的那个，重复的姓名为zs，年龄为18的那个对象？
        //如果，不能删除，在不修改main方法代码的前提下如何，是的删除生效？
        c.remove(new Person("zs", 18));
        System.out.println(c);
    }
}
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){ return true; }
        if(!(obj instanceof Person)) return false;
        Person person=(Person) obj;
        return person.id==id&&person.name==name;

    }
}
