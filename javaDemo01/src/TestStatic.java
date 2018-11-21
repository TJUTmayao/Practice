/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/29 15:34
 * @Description:
 */
public class TestStatic {
    /* 静态代码块执行时机 1.类实例化时
    *  2.类的静态方法被调用时。
    *  3.类的静态变量被调用时。
    *  不论哪种情况，静态方法只会执行一次（包括多次实例化）,仅在类被加载时执行。 */
}
class TestS{
    public String s ;
    public static String s2 = "ll";
    static {
        System.out.println("我执行了");
    }

    public static void testSta(){}

}