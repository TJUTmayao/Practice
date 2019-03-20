package Bishi;

import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/16 10:19
 * @Description:
 */
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.next());
        }
        int haveNum,lastNum;
        ArrayList<String> strings = new ArrayList<>();
        for (String str : list){
            haveNum = 1;
            lastNum = 0;
            if (str.length() == 0){continue;}
            StringBuilder chars = new StringBuilder(str);
            for (int i = 1; i < chars.length(); i++) {
                if (chars.charAt(i - 1) == chars.charAt(i)){
                    haveNum ++;
                }else {
                    lastNum = haveNum;
                    haveNum = 1;
                }
                if (lastNum == 2 && haveNum == 2){
                    chars.replace(i,i + 1,"");
                    i -- ;
                    haveNum --;
                }
                if (haveNum == 3){
                    chars.replace(i,i + 1,"");
                    i -- ;
                    haveNum --;
                }
            }
            strings.add(chars.toString());
        }
        for (String str : strings){
            System.out.println(str);
        }
    }
}
