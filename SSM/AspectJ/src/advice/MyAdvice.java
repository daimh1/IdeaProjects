package advice;

import Utils.TransactionManager;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.SQLException;

public class MyAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if ("transfer".equals(methodInvocation.getMethod().getName())){

            //dao只负责增删改查 具体操作
            //在此通过连接池获取一个connection，然后传给两个或者多个dao的操作，
            //开启事务
            Object invoke=null;
            try {

                //开启事物
                TransactionManager.beginTransaction();

                invoke = methodInvocation.proceed();
                TransactionManager.commit();
                System.out.println("ad1 commit!");
            }catch (Exception e){
                e.printStackTrace();
                try {
                    TransactionManager.rollback();
                    System.out.println("rollback!");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                invoke=false;
            }

            return    invoke;
        }else{

            return    methodInvocation.proceed();

        }
    }
}
