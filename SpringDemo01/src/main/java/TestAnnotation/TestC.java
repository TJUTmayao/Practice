package TestAnnotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Controller;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 10:33
 * @Description:
 */
@Controller()
public class TestC implements BeanNameAware {

    private String beanName;

    public void say(){
        System.out.println("我是controller  " + this.beanName);
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
