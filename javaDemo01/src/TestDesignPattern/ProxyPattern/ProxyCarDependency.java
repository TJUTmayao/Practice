package TestDesignPattern.ProxyPattern;

/**
 * 说明：聚合静态代理（推荐）
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 16:11
 * @Description:
 */
public class ProxyCarDependency implements ProxyInterface{

    private ProxyInterface car;

    @Override
    public void show() {

    }

    public ProxyCarDependency(ProxyInterface car){
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("开始执行");
        this.car.move();
        System.out.println("结束执行");
    }
}
