package TestDesignPattern.ProxyPattern.DynamicAdapter;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 说明：CGLIB动态代理
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 10:12
 * @Description:
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /* 拦截目标类所有方法调用（invocation） */
    @Override
    /*  参数： 目标类实例   目标方法反射实例  方法参数  Proxy类的实例 */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB代理开始");
        /* 调用父类的方法 */
        methodProxy.invokeSuper(o ,objects);
        System.out.println("CGLIB代理结束");
        return null;
    }
}
