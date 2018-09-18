package factory;

import Utils.TransactionManager;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import service.AccountService;
import service.AccountServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class ServiceFactory {
    public static AccountService getAccountService(){
        AccountServiceImpl accountService=new AccountServiceImpl();
        AccountService service= (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("transfer".equals(method.getName())) {

                            //dao只负责增删改查 具体操作
                            //在此通过连接池获取一个connection，然后传给两个或者多个dao的操作，
                            //开启事务
                            Object invoke = null;
                            try {

                                //开启事物
                                TransactionManager.beginTransaction();
                                invoke = method.invoke(accountService, args);
                                TransactionManager.commit();
                                System.out.println("commit!");
                            } catch (Exception e) {
                                e.printStackTrace();
                                try {
                                    TransactionManager.rollback();
                                    System.out.println("rollback!");

                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }

                                invoke = false;
                            }

                            return invoke;
                        } else {

                            return method.invoke(accountService, args);

                        }
                    }
                    });
        return service;
    }

    public static AccountService getAccountService2(){
        AccountServiceImpl accountService=new AccountServiceImpl();

        Callback callback=new org.springframework.cglib.proxy.InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("transfer".equals(method.getName())){
                    Object invoke = null;
                    try {

                        //开启事物
                        TransactionManager.beginTransaction();
                        invoke = method.invoke(accountService, args);
                        TransactionManager.commit();
                        System.out.println("commit!");
                    } catch (Exception e) {
                        e.printStackTrace();
                        try {
                            TransactionManager.rollback();
                            System.out.println("rollback!");

                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        invoke = false;
                    }

                    return invoke;
                }else{
                    return method.invoke(accountService, args);
                }

            }
        };
        return (AccountService) Enhancer.create(AccountServiceImpl.class,callback);
    }

}
