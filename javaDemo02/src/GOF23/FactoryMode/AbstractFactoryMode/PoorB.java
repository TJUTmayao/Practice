package GOF23.FactoryMode.AbstractFactoryMode;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/24 14:25
 * @Description:
 */
public class PoorB implements B {
    @Override
    public void say() {
        System.out.println("产品B 品质：合格");
    }
}
