package JavaReflex;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/19 10:36
 * @Description:
 */
public class TestDynamic {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Class c = null;
        try {
            /* 动态加载类 */
            c = Class.forName(sc.next());
            Father father = (Father) c.newInstance();
            father.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
interface Father{
    void show();
}
class FooOne implements Father{

    @Override
    public void show() {
        System.out.println("我是FooOne");
    }
}
class FooTwo implements Father{

    @Override
    public void show() {
        System.out.println("我是FooTwo");
    }
}