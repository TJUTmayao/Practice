package TestDesignPattern.SingletonMode;

/**
 * 说明：饿汉模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/19 16:28
 * @Description:
 */
public class MyCalssA {

    private static MyCalssA instance = new MyCalssA();

    private MyCalssA(){ }

    public MyCalssA getIntance(){ return instance; }

    public void say(){
        System.out.println("我是A");
    }
}
