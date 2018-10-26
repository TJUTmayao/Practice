/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/17 14:06
 * @Description:
 */
public class TestInstanceOf {
    public static void main(String[] arg){
        Stu2 a = new Stu2();
        String b = "1";
        /* 判断一个对象是否是某个类或是这个类的子类的对象 */
        System.out.println((a instanceof stu));
    }

    public static class stu{
        String s = "1";

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }

    public static class Stu2 extends stu{
        int a;
    }
}
