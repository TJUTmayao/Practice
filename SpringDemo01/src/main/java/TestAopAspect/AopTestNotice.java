package TestAopAspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/5 16:33
 * @Description:
 */
public class AopTestNotice {

    private static final int max = 5;
    private static List<Throwable> list = new ArrayList<Throwable>();

    public void before(){
        System.out.println("我是前置通知");
    }
    public void after(){
        System.out.println("我是后置通知");
    }
    public void exception(){
        System.out.println("我是抛出异常后通知");
    }
    public void onlyAfter(){
        System.out.println("我是后通知");
    }

    public Object aroundInit(ProceedingJoinPoint pjp , String name, int age){
        Object object = null;
        int tryNum = 0;
        System.out.println("含参环绕，执行前");
        do{
            System.out.println("第" +  (tryNum + 1) + "次尝试执行");
            try {
                object = pjp.proceed();
                return object;
            } catch (Throwable throwable) {
                tryNum ++;
                list.add(throwable);
            }
        }while (tryNum < max);
        System.out.println("含参环绕，执行后(执行失败)");
        return object;
    }
    public Object around(ProceedingJoinPoint pjp){
        /**
         *
         * 功能描述: 
         *
         * @param: [pjp]
         * @return: java.lang.Object
         * @auther: 11432_000
         * @date: 2018/11/6 14:51
         */
        Object proceed = null;
        try {
            System.out.println("环绕，方法执行之前");
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕，方法执行之后");
        return proceed;
    }
}
