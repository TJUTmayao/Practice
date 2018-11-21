package JavaReflex;

import java.lang.reflect.Method;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/19 14:53
 * @Description:
 */
public class TestMethedReflex {

    public static void main(String[] args){
        A a = new A();
        Class aClass = a.getClass();
        try {
            Method m = aClass.getMethod("addition", int.class, int.class);
            Object invoke1 = m.invoke(a, 10, 700);
            Method m2 = aClass.getMethod("addition", String.class, String.class);
            Object invoke = m2.invoke(a, "woshi", "YOU father");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void addition(int a,int b){
        System.out.println(a + b);
    }

    public void addition(String a,String b){
        System.out.println(a.toUpperCase() + b.toLowerCase());
    }
}