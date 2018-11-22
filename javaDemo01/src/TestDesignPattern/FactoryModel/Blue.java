package TestDesignPattern.FactoryModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 10:06
 * @Description:
 */
public class Blue implements ColorInterface{
    @Override
    public void showMyColor() {
        System.out.println("蓝色");
    }

    @Override
    public String getColor() {
        return "蓝色";
    }
}
