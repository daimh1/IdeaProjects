
import java.util.*;
import java.lang.reflect.*;
public class ReflectionTest {
    public static void main(String args[]){
        String name;
        if(args.length>0)name=args[0];
        else {
            Scanner in=new Scanner(System.in);
            System.out.println("enter class name:");
            name=in.next();
        }
        try {
            {
                Class c1=Class.forName(name);
                Class superc1=c1.getSuperclass();
                String modifiers=Modifier.toString(c1.getModifiers());
                if(modifiers.length()>0)System.out.print(modifiers+"| ");
                System.out.print("class"+name);
                if(superc1!=null&&superc1!=Object.class)System.out.print("extends"+superc1.getName());
                System.out.print("\n{\n");
                printConstructors((c1));
                System.out.println();

                //print
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.exit(0);
    }
    public static void  printConstructors(Class cl){
        Constructor[] constructors=cl.getConstructors();
        for(Constructor c:constructors){
            String name=c.getName();
            System.out.print("  ");
            String modifiers=Modifier.toString(c.getModifiers());
            if(modifiers.length()>0)System.out.print(modifiers+" ");
            System.out.print(name+"(");

            Class[] paramTypes=c.getParameterTypes();
            for(int j=0;j<paramTypes.length;j++){
                if(j>0)System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");

        }

    }
    public static  void printMethods(Class cl){
        Method[] methods=cl.getDeclaredMethods();
        for(Method m:methods){
            Class retType=m.getReturnType();
            String name=m.getName();

            System.out.print("  ");
            String modifiers=Modifier.toString(m.getModifiers());
            if(modifiers.length()>0)System.out.print(modifiers+" ");
            System.out.print(retType.getName()+" "+name+"(");

            Class[] paramTypes=m.getExceptionTypes();
            for(int j=0;j<paramTypes.length;j++){
                if(j>0)System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
            }
        }
    public static  void  printfFields(Class cl) {
        Field[] fields=cl.getDeclaredFields();
        for(Field f:fields){
            Class type=f.getType();
            String name=f.getName();
            System.out.print(" ");
            String modifiers= Modifier.toString(f.getModifiers());
            if(modifiers.length()>0)System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }
    }

