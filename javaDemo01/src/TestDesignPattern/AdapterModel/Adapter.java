package TestDesignPattern.AdapterModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 14:55
 * @Description:
 */
public class Adapter implements TargetInterface{
    private TransformInterface transformInterface;

    public Adapter(TransformInterface transformInterface){
        this.transformInterface = transformInterface;
    }

    @Override
    public void sayHello() {
        System.out.print("Hello ");
        this.transformInterface.sayPlace();
    }
}
