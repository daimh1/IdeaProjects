package Day11;

public class Class11_q3 {
    public static void main(String[] args){
        String a="abcdefg";
        int b=10;

        try {
            stException();
            System.out.println("输入正确");

        }

        catch (MyException e) {
            e.printStackTrace();
        }

        try {
            //stException();
            stException(a);
            System.out.println("输入正确");

        }

        catch (MyException e) {
            e.printStackTrace();
        }
        try {

            stException(123);
            System.out.println("输入正确");
            //stException("abc");
        }

        catch (MyException e) {
            e.printStackTrace();
        }
        try {

            stException("abc");
            System.out.println("输入正确");
        }

        catch (MyException e) {
            e.printStackTrace();
        }
    }

    protected static void stException() throws MyException{
        throw new MyException("没有字符");
    }
    protected static void stException(String a) throws MyException{
        if(a.length()>4){
            throw new MyException("字符串个数大于4");
        }

    }
    protected static void stException(int a)throws MyException{
        throw new MyException("输入的是数字");
    }

}
