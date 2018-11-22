package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:06
 * @Description:
 */
public class Green implements ColorInterface {
    @Override
    public String getColor() {
        return "绿色";
    }

    @Override
    public void showMyColor() {
        System.out.println("绿色");
    }
}
