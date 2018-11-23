package TestAopAspect;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/2 14:23
 * @Description:
 */
public class BusinessService {

    public void show(){
        System.out.println("我是业务类");
//        throw new RuntimeException("hhhhhhh");
    }

    public void showOther(String name, int age) throws Exception {
        System.out.println("我是" + name);
        throw new Exception("ccc");
    }

}
