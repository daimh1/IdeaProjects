package homework02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Realize {
    public static void main(String[] args) {
        PassiveMethod passiveMethod=new PassiveMethod();

        Passive proxy= (Passive) Proxy.newProxyInstance(passiveMethod.getClass().getClassLoader(),
                passiveMethod.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long t1=System.nanoTime();

                        Object invoke=method.invoke(passiveMethod,args);

                        long t2=System.nanoTime();

                        System.out.println("time:"+(t2-t1));

                        return invoke;
                    }
                });

        proxy.abc(100);
    }
}
