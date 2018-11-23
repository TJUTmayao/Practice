package TestAopApi;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.SQLOutput;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 15:24
 * @Description:
 */
public class TestAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前，方法名：" + methodInvocation.getMethod().getName());
        Object proceed = methodInvocation.proceed();
        System.out.println("环绕后，哈哈哈");
        return proceed;
    }
}
