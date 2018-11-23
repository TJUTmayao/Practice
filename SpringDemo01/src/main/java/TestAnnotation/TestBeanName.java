package TestAnnotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 10:57
 * @Description:
 */
public class TestBeanName implements BeanNameGenerator {

    @Override
    public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {
        String beanClassName = beanDefinition.getBeanClassName();
        String s = beanClassName.toUpperCase();
        return s;
    }

}
