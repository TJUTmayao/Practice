package TestDesignPattern.FactoryModel;

/**
 * 说明：工厂模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:02
 * @Description:
 */
public class ColorFactory extends SuperFactory{
    @Override
    public ColorInterface getColor(String className){
        ColorInterface colorInterface = null;
        try {
            Class cla = Class.forName("TestDesignPattern.FactoryModel." + className);
            colorInterface = (ColorInterface) cla.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colorInterface;
    }

    @Override
    public StationeryInterface getStationery(String className) {
        return null;
    }
}
