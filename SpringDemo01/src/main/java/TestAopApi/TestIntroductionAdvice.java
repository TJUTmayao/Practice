package TestAopApi;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 16:56
 * @Description:
 */
public class TestIntroductionAdvice extends DelegatingIntroductionInterceptor implements Lockable {

    private boolean locked = false;

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public boolean locked() {
        return this.locked;
    }


    public Object aroundAdvice(MethodInvocation methodInvocation)throws Throwable{
        if (locked() && methodInvocation.getMethod().getName().indexOf("set") == 0){
            throw new RuntimeException("不可改变变量");
        }
        return methodInvocation.proceed();
    }
}
