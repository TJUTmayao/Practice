package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:13
 * @Description:
 */
public abstract class MyHandler {

    protected MyHandler next;

    public MyHandler(MyHandler next) {
        this.next = next;
    }

    abstract void ICanDo(double discount);
}
