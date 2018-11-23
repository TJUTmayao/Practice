package TestAspectJ;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/8 15:36
 * @Description:
 */
@Component
@Scope("prototype")
@Aspect("perthis(this(TestFanXing.FanXingInterface))")
public class RandomAspectJ implements InitializingBean {
     private int s ;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.s = (int) (Math.random() * 100);
    }

    @Before("execution(* TestFanXing.*.*(..))")
    public void before(){
        System.out.println("我是随机数：" + this.s);
    }

    @After("execution(* TestFanXing.*.*(..))")
    public void after(){
        System.out.println("我是随机数：" + this.s);
    }
}
