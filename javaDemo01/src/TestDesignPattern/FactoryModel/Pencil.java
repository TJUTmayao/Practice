package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:24
 * @Description:
 */
public class Pencil implements StationeryInterface {
    @Override
    public void showMyType(ColorInterface color) {
        System.out.println("我是" + color.getColor() + "铅笔");
    }

    @Override
    public String getStationery() {
        return "铅笔";
    }
}
