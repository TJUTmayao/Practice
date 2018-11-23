package TestAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 10:34
 * @Description:
 */
@Component
@Scope("prototype")
public class TestA {

    public void say(){
        System.out.println("我是component :" + this.hashCode());
    }
}
