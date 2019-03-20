package Bishi;

import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/15 10:02
 * @Description:
 */
public class SecondQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        if (n < 1 || n > 10000 || m < 1 || m > 1000 || c < 1 || c > 50){}
        int color;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num_i = scanner.nextInt();
            for (int j = 0; j < num_i; j++) {
                color = scanner.nextInt();
                List<Integer> list = map.get(color);
                if (list == null){
                    list = new ArrayList<>();
                    list.add(i);
                    map.put(color,list);
                }else {
                    list.add(i);
                }
            }
        }
        int end ,num;
        num = 0;
        boolean isHave ;
        Set<Integer> keySet = map.keySet();
        for (Integer in : keySet){
            isHave = false;
            List<Integer> list = map.get(in);
            if (list == null || list.size() == 0){
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                int start = list.get(i);
                end = (start + m - 1) % n;
                if (end > start){
                    if (i + 1 < list.size() && list.get(i + 1) <= end){isHave = true;}
                }else if(end < start){
                    Integer theEnd = list.get((i + 1) % list.size());
                    if (theEnd <= end || (theEnd > start && theEnd < n - 1)){
                        isHave = true;
                    }
                }
                if (isHave){break;}
            }

            if(isHave){num ++;}
        }
        System.out.println(num);
    }
}
