package TestAopAspect;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 09:59
 * @Description:
 */
public class ParentInImpl implements ParentInterface{

    @Override
    public void say() {
        System.out.println("我是新父类");
    }
}
