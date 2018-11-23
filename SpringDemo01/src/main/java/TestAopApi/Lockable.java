package TestAopApi;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/6 17:00
 * @Description:
 */
public interface Lockable {

    void lock();
    void unlock();
    boolean locked();

}
