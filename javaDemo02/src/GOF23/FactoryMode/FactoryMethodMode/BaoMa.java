package GOF23.FactoryMode.FactoryMethodMode;

import GOF23.FactoryMode.Product;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/24 13:39
 * @Description:
 */
public class BaoMa implements Product {
    @Override
    public void run() {
        System.out.println("宝马");
    }
}
