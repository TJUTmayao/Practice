package TestDesignPattern.SingletonMode;

/**
 * 说明：静态内部类/登记式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/20 14:55
 * @Description:
 */
public class MyClassD {

    private static class MyClassE{
        private static final MyClassD D_INSTANCE= new MyClassD();
    }
    private MyClassD(){ }

    public static MyClassD getInstance(){
        return MyClassE.D_INSTANCE;
    }
}
