package homework03.com.cskaoyan.proxy;

import homework03.com.cskaoyan.utils.TransactionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionProxy {
    public static Object proxy(Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new TransactionInvocationHandler(object));
    }
}

class TransactionInvocationHandler implements InvocationHandler {
    private Object proxy;

    TransactionInvocationHandler(Object object) {
        this.proxy = object;
    }

    public Object invoke(Object obj, Method method, Object[] objects) throws Throwable {
        TransactionUtils.beganTransaction();
        Object result = null;
        try {
            // 调用业务方法
            result = method.invoke(proxy, objects);
            TransactionUtils.commit();
        } catch (Exception e) {
            TransactionUtils.rollback();
        } finally {
            TransactionUtils.close();
        }
        return result;
    }
}