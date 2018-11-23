package TestAopApi;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 15:17
 * @Description:
 */
public class TestThrowing implements ThrowsAdvice {

    public void afterThrowing(Method m ,Object[] args ,Object target ,Exception ex){
        for (Object o : args){
            System.out.print("参数名:" + o.getClass().getName());
        }
        System.out.println();
        System.out.println("类名：" + target.getClass().getName());
        System.out.println("异常信息：" + ex.getMessage());
    }
}
