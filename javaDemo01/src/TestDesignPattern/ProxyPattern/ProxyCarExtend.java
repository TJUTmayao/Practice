package TestDesignPattern.ProxyPattern;

/**
 * 说明：继承静态代理(不推荐)
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 16:07
 * @Description:
 */
public class ProxyCarExtend extends Car {

    @Override
    public void move() {
        System.out.println("开始执行");
        super.move();
        System.out.println("结束执行");
    }
}
