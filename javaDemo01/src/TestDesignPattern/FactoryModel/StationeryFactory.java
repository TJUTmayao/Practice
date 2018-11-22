package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:53
 * @Description:
 */
public class StationeryFactory extends SuperFactory{

    @Override
    public ColorInterface getColor(String className) {
        return null;
    }
    @Override
    public StationeryInterface getStationery(String className){
        StationeryInterface stationeryInterface = null;
        try {
            Class<?> aClass = Class.forName("TestDesignPattern.FactoryModel." + className);
            stationeryInterface = (StationeryInterface) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stationeryInterface;
    }
}
