package TestDesignPattern.FactoryModel;

/**
 * 说明：工厂模式+抽象工厂模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:09
 * @Description:
 */
public class TestMain {
    public static void main(String[] args){
        /*ColorFactory factory = new ColorFactory();
        ColorInterface red = factory.getColor("Red");
        ColorInterface blue = factory.getColor("Blue");
        blue.showMyColor();
        red.showMyColor();*/
        AbstractFactory abstractFactory = new AbstractFactory();
        SuperFactory colorFactory = abstractFactory.getFactory("ColorFactory");
        ColorInterface red = colorFactory.getColor("Red");
        red.showMyColor();
    }
}
