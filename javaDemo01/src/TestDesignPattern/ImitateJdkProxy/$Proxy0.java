package TestDesignPattern.ImitateJdkProxy;
import java.lang.reflect.Method;
import TestDesignPattern.ImitateJdkProxy.InvocationHandler;
public class $Proxy0 implements TestDesignPattern.ProxyPattern.ProxyInterface{

    private InvocationHandler handler;
    public $Proxy0(InvocationHandler handler) {
         this.handler = handler;
    }
    @Override
    public void show(java.lang.String arg0) {
        try {
            Method m = TestDesignPattern.ProxyPattern.ProxyInterface.class.getMethod("show");
            handler.invoke(this, m);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void move() {
        try {
            Method m = TestDesignPattern.ProxyPattern.ProxyInterface.class.getMethod("move");
            handler.invoke(this, m);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
