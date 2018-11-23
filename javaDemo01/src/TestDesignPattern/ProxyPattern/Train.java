package TestDesignPattern.ProxyPattern;

import java.util.Random;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/22 10:11
 * @Description:
 */
public class Train implements ProxyInterface{

    @Override
    public void move(){
        System.out.println("火车行驶中。。。。");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show(String msg) {

    }
}
