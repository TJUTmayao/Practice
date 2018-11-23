package TestDesignPattern.ProxyPattern;

import TestDesignPattern.ImitateJdkProxy.InvocationHandler;
import TestDesignPattern.ImitateJdkProxy.MyInvocation;
import TestDesignPattern.ImitateJdkProxy.Proxy;
import TestDesignPattern.ProxyPattern.DynamicAdapter.CglibProxy;
import TestDesignPattern.ProxyPattern.DynamicAdapter.InvocationRealization;

import java.lang.reflect.Method;

/**
 * 说明：代理模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 15:58
 * @Description:
 */
public class TestMain {

    public static void main(String[] args){
        Car car = new Car();
//        car.move();
//        ProxyInterface  dependency2 = new ProxyCarDependency2(car);
//        ProxyInterface dependency = new ProxyCarDependency(dependency2);
//        dependency.move();
        /* JDK动态代理 */
       /* InvocationRealization realization = new InvocationRealization(car);
        Class<?> aClass = car.getClass();
        ProxyInterface o =(ProxyInterface) Proxy.newProxyInstance(aClass.getClassLoader(),
                aClass.getInterfaces(), realization);
        o.move();*/
       /* CGLIB动态代理 */
        /*CglibProxy cglibProxy = new CglibProxy();
        Train t =(Train) cglibProxy.getProxy(Train.class);
        t.move();*/

        /* 模拟动态代理 */
        Train train = new Train();
        Class<? extends Train> aClass = train.getClass();
        try {
            ProxyInterface proxy =(ProxyInterface) Proxy.newProxyInstance(aClass.getInterfaces()[0],
                    new MyInvocation(train));
            proxy.move();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
