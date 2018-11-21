package TestDesignPattern.SingletonMode;

/**
 * 说明：单例模式-懒汉模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/20 10:00
 * @Description:
 */
public class MyClassB {

    private MyClassB(){}

    private static MyClassB instance = null;

    public MyClassB getInstance(){
        if(instance == null){
            instance = new MyClassB();
        }
        return instance;
    }

    public void say(){
        System.out.println("我是B");
    }
}
