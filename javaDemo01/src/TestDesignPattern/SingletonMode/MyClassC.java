package TestDesignPattern.SingletonMode;

/**
 * 说明：DCL（双检锁）
 *
 * @Auther: 11432_000
 * @Date: 2018/11/20 10:41
 * @Description:
 */
public class MyClassC {

    private volatile static MyClassC instance = null;
    private MyClassC(){ }
    public static MyClassC getInstance(){
        if(instance == null){
            synchronized(MyClassC.class){
                if (instance == null){
                    instance = new MyClassC();
                }
            }
        }
        return instance;
    }
}
