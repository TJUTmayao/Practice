package TestDesignPattern.ImitateJdkProxy;

import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 14:24
 * @Description:
 */
public interface InvocationHandler {
    public void invoke(Object o, Method m);
}
