package TestDesignPattern.ResponsibilityChainModel;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:37
 * @Description:
 */
public class HandlerMaster {

    public static MyHandler getHandler(){
        MyHandler handler = new Handler001(new Handler002(new Handler003(new Handler004(null))));
        return handler;
    }
}
