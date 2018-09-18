package homework03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Myadvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if("transfer".equals(methodInvocation.getMethod().getName())){
            //System.out.println(methodInvocation.getMethod().getName());
            long time1=System.currentTimeMillis();
            Object invoke=null;
            invoke=methodInvocation.proceed();
            long time2=System.currentTimeMillis();
            System.out.println("time ="+(time2-time1));
            if((time2-time1)>300){
                throw new Exception("overtime");
            }
            return invoke;
        }


        return methodInvocation.proceed();
    }
}
