package proxy;

import Manager.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy {
    public static Object proxyFor(Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        TransactionManager.beginTransaction();
                        Object result=null;
                        try {
                            result=method.invoke(proxy,args);
                            TransactionManager.commit();
                        }catch (Exception e){
                            TransactionManager.rollback();
                        }finally {
                            TransactionManager.close();
                        }


                        return result;
                    }
                });
    }
}
