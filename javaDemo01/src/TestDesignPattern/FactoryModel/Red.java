package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:05
 * @Description:
 */
public class Red implements ColorInterface {
    @Override
    public void showMyColor() {
        System.out.println("红色");
    }

    @Override
    public String getColor() {
        return "红色";
    }
}
