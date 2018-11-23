package TestAnnotation;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 13:44
 * @Description:
 */
public class TestsBean implements BeanNameAware {

    private String beanNamr;

    public void show(){
        System.out.println("这是：" + this.beanNamr );
    }

    @Override
    public void setBeanName(String s) {
        this.beanNamr = s;
    }
}
