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
@Order(3)
public class BeanArrayThree implements BeanInteface {
    @Override
    public void say() {
        System.out.println("我是bean3号");
    }
}
