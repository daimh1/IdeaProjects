package Day10;

public class Class10_1 implements Cloneable{
    private int age;//阿里规范中规定pojo类中的属性强制使用包装类型，这里只是测试

    private String name;

    public Class10_1(Integer age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    private static void copyRealObject() throws CloneNotSupportedException{
        Class10_1 p = new Class10_1(23, "zhang");
        Class10_1 p1 = (Class10_1) p.clone();
        System.out.println(p);
        System.out.println(p1);
        System.out.println("pName："+p.name.hashCode());
        System.out.println("p1Name："+p1.name.hashCode());
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        copyRealObject();
    }
}

