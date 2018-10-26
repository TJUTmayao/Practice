package NarcissisticNumber;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 09:03
 * @Description:
 */
public class MainClass {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int num = 0;
        String numberString = String.valueOf(number);
        for (int i = 0 ;i < numberString.length(); i++){
            char one =(char) (numberString.charAt(i) - '0');
            num += Integer.valueOf(one) * Integer.valueOf(one) * Integer.valueOf(one);
        }
        if (num == number){
            System.out.println("这是一个水仙花数");
        }else {
            System.out.println("这不是水仙花数");
        }
    }
}
