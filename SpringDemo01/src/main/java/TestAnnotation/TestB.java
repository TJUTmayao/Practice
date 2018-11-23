package TestAnnotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 10:23
 * @Description:
 */
@Service
public class TestB implements BeanNameAware {

    private String beanName;

    public void say(){
        System.out.println("我是service");
    }


    @Override
    public void setBeanName(String s) {

    }
}


