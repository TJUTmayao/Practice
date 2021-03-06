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
            /* 第一个参数为方法名称 ，其余为参数类型或参数类型数组*/
            Method m = aClass.getMethod("addition", int.class, int.class);
            System.out.println(m.toString());
            /* 参数一：反射的对象  参数二及以后：该方法参数列表*/
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