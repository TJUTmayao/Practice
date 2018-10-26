package IsoscelesTriangle;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 09:26
 * @Description:
 */
public class MainClass {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入三角形大小");
        int a = sc.nextInt();
        while (a < 2 || a % 2 == 0){
            System.out.println("麻烦输入一个奇数");
            a = sc.nextInt();
        }
        int diBianChang = a * 2 - 1;
        /* 等腰三角形 */
        for (int i = 0; i < a ; i++){
            for (int j = 0 ;j < diBianChang; j++){
                if (j < diBianChang / 2 - i){
                    System.out.print(" ");
                }else  if (j - diBianChang / 2 <= i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        a = 0;
        while (a < 2 || a % 2 == 0){
            System.out.println("菱形层数");
            a = sc.nextInt();
        }
        /* 菱形 */
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < a; j++) {
                if (i <= a / 2){
                    if (j >= a / 2 - i && j <= a / 2 + i ){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
                if (i > a / 2){
                    int k = i - a/2;
                    if (j >= k && j < a - k){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        /* 空芯 菱形 */
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < a; j++) {
                if (i <= a / 2){
                    if (j == a / 2 - i || j == a / 2 + i ){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
                if (i > a / 2){
                    int k = i - a/2;
                   if (j == k || j == a - k - 1){
                       System.out.print("*");
                   }else {
                       System.out.print(" ");
                   }
                }
            }
            System.out.println();
        }
    }
}
