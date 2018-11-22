package TestDesignPattern.SingletonMode;

/**
 * 说明：单例模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/20 10:13
 * @Description:
 */
public class TestMian {
    public static void main(String[] args){
        MyClassF instance = MyClassF.INSTANCE;
        instance.say();
    }
}
