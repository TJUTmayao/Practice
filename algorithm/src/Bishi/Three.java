package Bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/16 10:54
 * @Description:
 */
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            Integer[] array = new Integer[size];
            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }
            Arrays.sort(array);
            Integer[] array2 = new Integer[size];
            int x = 0;
            for (int j = 0 ,k = array.length - 1; j <= k ; j++,k--) {
                array2[x++] = array[j];
                array2[x++] = array[k];
            }
            ArrayList<Integer> intes = new ArrayList<Integer>();
            for (int j = 0; j < array2.length; j++) {
                intes.add(array2[j]);
            }
            list.add(intes);
        }
        int last,next;
        for (ArrayList<Integer> ints : list){
            int[] mark = new int[ints.size()];
            for (int i = 0; i < mark.length; i++) {
                mark[i] = 1;
            }
            for (int i = 0; i < ints.size(); i++) {
                last = i - 1;
                next = i + 1;
                if (last < 0){last = ints.size() - 1;}
                if (next > ints.size() - 1){next = 0;}
                if (last != next && ints.get(i) > ints.get(last)){
                    if (mark[i] <= mark[last]){
                        mark[i] = mark[last] + 1;
                    }
                }
                if (ints.get(i) > ints.get(next)){
                    if (mark[i] <= mark[next]){
                        mark[i] = mark[next] + 1;
                    }
                }
            }
            int num = 0;
            for (int s : mark){
                num += s;
                System.out.print(s + "\t");
            }
            System.out.println(num);
        }
    }

}
