package PrimeNumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 14:20
 * @Description:
 */
public class MainClass {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int max = sc.nextInt();
        boolean flag;
        for (int i = 1; i <= max; i++) {
            flag = false;
            for (int j = 1 ;j <= i; j++){
                if (i % j == 0){
                    if (i != j && j != 1){
                        flag = true;
                    }
                }
            }
            if (!flag){
                list.add(i);
            }
        }
        System.out.println("0到" + max + "的质数有：");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
