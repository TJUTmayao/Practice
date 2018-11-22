package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:34
 * @Description:
 */
public class Pen implements StationeryInterface {
    @Override
    public void showMyType(ColorInterface color) {
        System.out.println("我是" + color.getColor() + "钢笔");
    }

    @Override
    public String getStationery() {
        return "钢笔";
    }
}
