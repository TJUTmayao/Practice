package TestDesignPattern.ProxyPattern.DynamicAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 说明：JDK动态代理
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 09:25
 * @Description:
 */
public class InvocationRealization implements InvocationHandler {

    private Object target;

    public InvocationRealization(Object target) {
        this.target = target;
    }

    @Override
    /* 代理对象(?) 被代理对象的方法  方法的参数数组 */
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        /* 返回方法的返回值 */
        System.out.println("动态代理开始。。。");
        method.invoke(target,objects);
        System.out.println("动态代理结束。。。");
        return null;
    }
}
