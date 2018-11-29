package HomeWork;

import MyUtils.CglibProxy;
import MyUtils.TimeUtils;

import java.sql.Time;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/28 10:21
 * @Description:
 */
public class Loop {

    public static void main(String[] args){
//       Loop loop = new Loop();
//       loop.nineNine();
//        CglibProxy proxy = new CglibProxy();
//        Loop proxy1 =(Loop) proxy.getProxy(Loop.class);
//        proxy1.nineNine();
        TimeUtils.showExecutiveTime(new Loop(),"nineNine",null);
    }

    public void nineNine(){
        int even = 0;
        int odd = 0;
        for (int i = 1; i <= 100;i++){
            if (i % 2 == 0){
                even += i;
            }else {
                odd += i;
            }
        }
        System.out.println("偶数和" + even + "奇数和" + odd );
        for (int i = 1,j = 0; i <= 1000 ; i++) {
            if (i % 5 == 0){
                System.out.print(i + "\t");
                j++;
            }if (j >= 5){
                System.out.println();
                j = 0;
            }
        }
    }
}
