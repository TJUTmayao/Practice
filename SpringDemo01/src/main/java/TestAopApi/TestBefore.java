package TestAopApi;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 14:59
 * @Description:
 */
public class TestBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method m, Object[] args, Object target) {
        for (Object o : args) {
            System.out.print("参数名:" + o.getClass().getName());
        }
        System.out.println();
        System.out.println("类名：" + target.getClass().getName());
    }
//    psvm
}
