package TestAspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/8 10:04
 * @Description:
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* TestAspectJ.My*.sa*(..))")
    public void advice1(){}


    @Pointcut("within(TestAspectJ.*)")
    public void advice2(){}


    @Pointcut("advice2() && advice1()")
    public void advice3(){}

    @Before("execution(String save(..)) && @annotation(myAnnotation)")
    public void before(MyAnnotation myAnnotation){
        System.out.println("我是before" + "  " + myAnnotation.value());
    }

    @AfterReturning(pointcut = "advice1()", returning = "arg")
    public void afterReturning(String arg){
        System.out.println("我是AfterReturning ，返回值：" + arg);
    }

    @AfterThrowing(pointcut = "advice1()" ,throwing = "arg")
    public void afterThrowing(Exception arg){
        System.out.println("我是AfterThrowing ，返回值：" + arg.getMessage());
    }

    @After("advice1()")
    public void after(){
        System.out.println("我是After");
    }


    @Around("advice1()")
    public Object around(ProceedingJoinPoint pjp){
        Object proceed = null;
        System.out.println("我是AroundBefore");
        try {
            proceed = pjp.proceed();
            System.out.println(proceed.getClass().toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("我是AroundAfter");
        return proceed;
    }

    @After("execution(* TestFanXing.FanXing.*(..)) && args(s)")
    public void fanxing(String s){
        System.out.println(s);
    }
}
