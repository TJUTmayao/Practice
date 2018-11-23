package TestAopApi;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 15:12
 * @Description:
 */
public class TestAfterReturning implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("返回值：" + o.getClass().getName());
        for (Object object : objects){
            System.out.print("参数名:" + object.getClass().getName());
        }
        System.out.println();
        System.out.println("类名：" + o1.getClass().getName());
    }
}
