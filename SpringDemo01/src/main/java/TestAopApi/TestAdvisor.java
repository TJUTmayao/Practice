package TestAopApi;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/7 09:32
 * @Description:
 */
public class TestAdvisor extends DefaultIntroductionAdvisor {

    public TestAdvisor(){
        super(new TestIntroductionAdvice(), Lockable.class);
    }
}
