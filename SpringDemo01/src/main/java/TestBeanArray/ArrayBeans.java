package TestBeanArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 14:20
 * @Description:
 */
@Component
public class ArrayBeans {

    @Autowired
    private List<BeanInteface> list;
    @Autowired
    @Qualifier("beanArrayOne")
    private BeanInteface beanInteface;

    public List<BeanInteface> getList() {
        return list;
    }

    public void setList(List<BeanInteface> list) {
        this.list = list;
    }

    public BeanInteface getBeanInteface() {
        return beanInteface;
    }

    public void setBeanInteface(BeanInteface beanInteface) {
        this.beanInteface = beanInteface;
    }
/*  @Autowired
    private Map<String, BeanInteface> list;

    public Map<String, BeanInteface> getList() {
        return list;
    }

    public void setList(Map<String, BeanInteface> list) {
        this.list = list;
    }*/
}
