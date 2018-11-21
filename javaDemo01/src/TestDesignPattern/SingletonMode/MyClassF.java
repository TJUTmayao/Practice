package TestDesignPattern.SingletonMode;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/20 15:21
 * @Description:
 */
public enum MyClassF {
    INSTANCE;
    /* 其他方法，MyClassF需要实现的方法  */
    public void say(){
        System.out.println("我是F");
    }
}
