package TestAspectJ;

import org.springframework.stereotype.Service;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/8 10:22
 * @Description:
 */
@Service
public class MyAspectTest {

    @MyAnnotation("MyAnnotation")
    public String save(String name){
        System.out.println("我是业务方法>>" + name);
//        throw new RuntimeException("666666666666666666666666");
        return "IG NB";
    }
}
