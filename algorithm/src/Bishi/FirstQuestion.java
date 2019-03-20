package Bishi;

import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/15 09:02
 * @Description:
 */
public class FirstQuestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            List<Integer> list = map.get(s);
            if (list == null){
                list = new ArrayList<>();
                list.add(i + 1);
                map.put(s,list);
            }else {
                list.add(i + 1);
            }
        }
        int q = sc.nextInt();
        int start,end,targetK;
        for (int i = 0; i < q; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            targetK = sc.nextInt();
            List<Integer> integers = map.get(targetK);
            int num = 0;
            if (integers != null){
                for (Integer in : integers){
                    if (in >= start && in <= end){
                        num ++;
                    }else if (in > end){
                        break;
                    }
                }
            }
            System.out.println(num);
        }
    }
}
