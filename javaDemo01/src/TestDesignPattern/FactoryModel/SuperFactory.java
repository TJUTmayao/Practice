package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:57
 * @Description:
 */
public abstract class SuperFactory {
    public abstract ColorInterface getColor(String className);
    public abstract StationeryInterface getStationery(String className);
}
