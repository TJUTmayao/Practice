package TestDesignPattern.ResponsibilityChainModel;

import java.util.Random;

/**
 * 说明：责任链模式
 *
 * @Auther: 11432_000
 * @Date: 2018/11/23 16:12
 * @Description:
 */
public class TestMain {

    public static void main(String[] args){
        MyHandler master = HandlerMaster.getHandler();
        for (int i = 0; i < 100; i++) {
           double x = Math.random();
           master.ICanDo(x);
        }
    }
}
