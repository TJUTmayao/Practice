package Sort.BubbleSort;

import MyUtils.ArrayUtils;

/**
 * 说明：冒泡排序 O(n²) 稳定 原地
 *
 * @Auther: 11432_000
 * @Date: 2019/1/18 09:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
        bubbleSort(array);
        System.out.println(ArrayUtils.isOrder(array));
        System.out.println(ArrayUtils.intArrayToString(array));
    }

    public static void bubbleSort(int... array){
        int k;
        boolean isExchange = false;
        for (int i = array.length - 1; i > 0; i --) {
            for (int j = 0; j < i; j++) {
                if (array[j + 1] < array[j]){
                    k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                    isExchange = true;
                }
            }
            if (!isExchange){
                break;
            }
        }
    }
}
