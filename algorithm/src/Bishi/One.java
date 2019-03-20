package Bishi;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/16 10:02
 * @Description:
 */
public class One {

    public static void main(String[] args) {
        int[] coin = {1,4,16,64};
        int haveMoney = 1024;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int coinNum = haveMoney - N;
        int num = 0;
        while(coinNum > 0){
            for (int i = coin.length - 1; i >= 0; i--) {
                if (coinNum >= coin[i]){
                    coinNum -= coin[i];
                    num ++;
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
