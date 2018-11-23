package TestBeanArray;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 14:18
 * @Description:
 */
@Component
@Order(1)
public class BeanArrayOne implements BeanInteface {
    @Override
    public void say() {
        System.out.println("我是bean1号");
    }
}
