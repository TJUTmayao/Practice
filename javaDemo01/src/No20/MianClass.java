package No20;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 09:28
 * @Description:
 */
public class MianClass {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int x = 1;
        int y = 1;
        int z = x + y;
        while (a < 3){
            System.out.println("请输入一个大于3的数");
            a = sc.nextInt();
        }
        for (int i = 0; i < a - 3; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        System.out.println(z);
    }
}
