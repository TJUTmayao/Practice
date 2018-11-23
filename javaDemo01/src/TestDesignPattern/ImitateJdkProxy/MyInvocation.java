package TestDesignPattern.ImitateJdkProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 15:26
 * @Description:
 */
public class MyInvocation implements InvocationHandler{

    private Object target;

    public MyInvocation(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {
        long befor = System.currentTimeMillis();
        try {
            System.out.println("开始记录");
            m.invoke(this.target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("结束记录 行驶时间：" + (after - befor) + "ms");
    }
}
