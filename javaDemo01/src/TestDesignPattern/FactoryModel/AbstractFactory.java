package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 14:12
 * @Description:
 */
public class AbstractFactory {

    SuperFactory getFactory(String factroryName){
        SuperFactory superFactory = null;
        if (factroryName.indexOf("Factory") == -1){
            throw new RuntimeException("这不是一个工厂！" + factroryName.indexOf("Factory"));
        }
        try {
            Class<?> aClass = Class.forName("TestDesignPattern.FactoryModel." + factroryName);
            superFactory = (SuperFactory) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return superFactory;
    }
}
