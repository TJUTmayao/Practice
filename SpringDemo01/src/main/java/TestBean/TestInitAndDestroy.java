package TestBean;

import TestPojo.Info;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 说明：注入方式：构造和设值注入
 *       初始化和销毁：1 在xml中配置init/destroy-method配置项
 *                     2 实现InitializingBean, DisposableBean接口。重写其方法。
 *                     3 执行顺序先接口后配置项。
 *
 * @Auther: 11432_000
 * @Date: 2018/10/31 11:03
 * @Description:
 */
public class TestInitAndDestroy implements InitializingBean, DisposableBean {

    private String name;
    private String status;
    private Info info;

    public TestInitAndDestroy(Info info){
        System.out.println("构造注入");
        this.info = info;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void init(){
        info.setIDCardNumber("140203199707142990");
    }

    public void stop(){
        System.out.println("销毁");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
