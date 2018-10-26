package Great;

import java.util.Map;
import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 13:48
 * @Description:
 */
public class MainClass {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        double sum = 0.0;
        double max = 0.0;
        double min = 100.0;
        double pingjun = 0.0;
        while (i < 5){
            Double great = sc.nextDouble();
            if (great > 100 || great < 0){
                System.out.println(" 请重新输入 范围0-100");
            }else {
                if (max < great){
                    max = great;
                }
                if (min > great){
                    min = great;
                }
                sum += great;
                pingjun = sum / (i + 1);
                System.out.println("最高："+ max + " 最低：" + min + " 平均值：" + pingjun + " 总分：" + sum);
                i++;
            }
        }
    }
}
