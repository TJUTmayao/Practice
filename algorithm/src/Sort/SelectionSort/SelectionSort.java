package Sort.SelectionSort;

import MyUtils.ArrayUtils;

/**
 * 说明：选择排序 O(n²) 不稳定 原地
 *
 * @Auther: 11432_000
 * @Date: 2019/1/18 09:05
 * @Description:
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
        selectionSort(array);
        System.out.println(ArrayUtils.isOrder(array));
        System.out.println(ArrayUtils.intArrayToString(array));
    }

    public static void selectionSort(int... array){
        int minIndex = 0;
        int min;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            min = array[minIndex];
            array[minIndex] = array[i];
            array[i] = min;
        }
    }
}
