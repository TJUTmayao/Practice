package TestDesignPattern.ProxyPattern;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/21 15:54
 * @Description:
 */
public class Car implements ProxyInterface{

    @Override
    public void move(){
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(((int)(Math.random()*2000)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long stop = System.currentTimeMillis();
        System.out.println("耗时：" + (stop - start) + "ms");
    }

    @Override
    public void show(String msg) {

    }

    public void show(String a,String b,int c){}


}
