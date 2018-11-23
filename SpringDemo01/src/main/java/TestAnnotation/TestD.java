package TestAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/1 13:44
 * @Description:
 */
public class TestD {

    /*@Autowired(required = true)*/
    private TestsBean testsBean;

//    @Autowired
    @Required
    public void setTestsBean(TestsBean testsBean) {
        this.testsBean = testsBean;
    }

/*    @Autowired
    TestD(TestsBean testsBean){
        this.testsBean = testsBean;
    }*/
    public void say(){
        testsBean.show();
    }
}
