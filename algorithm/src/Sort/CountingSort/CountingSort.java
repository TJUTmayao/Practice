package Sort.CountingSort;

import MyUtils.ArrayUtils;

/**
 * 说明：计数排序 ,min的index为0     O(n) 稳定 空间复杂度O(n)
 *
 * @Auther: 11432_000
 * @Date: 2019/1/19 08:51
 * @Description:
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
        int[] ints = countingSort(array);
        System.out.println(ArrayUtils.intArrayToString(ints));
        System.out.println(ArrayUtils.isOrder(ints));
    }

    private static int[] countingSort(int... array){
        int min = ArrayUtils.getMin(array);
        int[] bucketElementNumber = ArrayUtils.getCountingSortCount(array);
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int count = (bucketElementNumber[array[i] - min] --) - 1;
            newArray[count] = array[i];
        }
        return newArray;
    }
}
