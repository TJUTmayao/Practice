package TestDesignPattern.AdapterModel;

/**
 * 说明：适配器模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 15:04
 * @Description:
 */
public class TestMain {
    public static void main(String[] args){
        Transform transform = new Transform();
        TargetInterface adapter = new Adapter(transform);
        adapter.sayHello();
    }
}
