package TestAopApi;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/7 11:28
 * @Description:
 */
public class TestSave implements SaveInterface{


    @Override
    public String save() {
        System.out.println("我是主业务");
//        throw new RuntimeException("5555");
        return "success";
    }
}
