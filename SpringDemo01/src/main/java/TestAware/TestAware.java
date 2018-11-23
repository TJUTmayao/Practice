package TestAware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/31 14:07
 * @Description:
 */
public class TestAware implements ApplicationContextAware, BeanNameAware, InitializingBean {

    private String beanName;
    private int random;

    public void init(){
        System.out.println("初始化数：" + this.random);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName");
        this.beanName = s;
        this.random = ((int)(Math.random()*100));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TestAware bean =(TestAware) applicationContext.getBean(beanName);
        System.out.println(bean.getBeanName() + bean.getRandom());
    }

    public int getRandom() {
        return random;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我是接口初始化方法");
    }
}
