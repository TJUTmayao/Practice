package TestDesignPattern.AdapterModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 15:07
 * @Description:
 */
public class Transform implements TransformInterface {
    @Override
    public void sayPlace() {
        System.out.println("world");
    }
}
