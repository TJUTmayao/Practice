package TestDesignPattern.ProxyPattern;

/**
 * 说明：聚合静态代理（推荐）
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 16:11
 * @Description:
 */
public class ProxyCarDependency2 implements ProxyInterface{

    private ProxyInterface car;

    public ProxyCarDependency2(ProxyInterface car){
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("开始日志。。。");
        this.car.move();
        System.out.println("结束日志。。。");
    }

    @Override
    public void show() {
        Class<? extends ProxyCarDependency2> aClass = this.getClass();

    }
}
