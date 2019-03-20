package Bishi;

import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/15 12:03
 * @Description:
 */
public class ThirdQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int maxExchange = scanner.nextInt();
        char[] array = str.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = map.get(array[i]);
            if (list == null){
                list = new ArrayList<>();
                list.add(i);
                map.put(array[i] ,list);
            }else {
                list.add(i);
            }
        }
    }

    public static int getExchangeNum(int ele1,int ele2){
        return ele2 - ele1 - 1;
    }
}
