package JavaReflex;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/19 10:09
 * @Description:
 */
public class TestClass {
    public static void main(String[] args){
        /* 静态加载类 */
        Foo foo = new Foo();
        /* 方法1 */
        Class c1 = Foo.class;
        /* 方法2 */
        Class c2 = foo.getClass();
        /* 方法3 */
        Class c3 = null;
        try {
            c3 = Class.forName("JavaReflex.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Foo o =(Foo) c1.newInstance();
            o.show();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Foo{
     void show(){
         System.out.println("Foo!");
     }
}
