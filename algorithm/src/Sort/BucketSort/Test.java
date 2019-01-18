package Sort.BucketSort;

import MyUtils.ArrayUtils;

/**
 * 说明：桶排序  最好O(n)，最差O(nlogn) 不稳定 空间复杂度O(n)
 *
 * @Auther: 11432_000
 * @Date: 2019/1/18 09:27
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
        int[][] bucketsByValue = ArrayUtils.getBucketsByValue(array, 5);
        for (int i = 0; i < 5; i++) {
            System.out.println(ArrayUtils.intArrayToString(bucketsByValue[i]));
        }
    }

    public static void bucketSort(int[] array ,int numberOfPackets){
        int max = ArrayUtils.getMax(array);
        int min = ArrayUtils.getMin(array);
        int[][] buckets = new int[numberOfPackets][];
        for (int i = 0; i < numberOfPackets; i++) {

        }
    }

    public static void quickSort(int[] array ,int low ,int top){
        if (low >= top){ return;}
        int pivotIndex = selectionSort(array, low, top);
        quickSort(array ,low ,pivotIndex - 1);
        quickSort(array ,pivotIndex + 1,top);
    }

    public static int selectionSort(int[] array ,int low ,int top){
        int pivot = array[top];
        int i,j,k;
        for (i = low,j = low; i < top; i++) {
            if (array[i] < pivot){
                k = array[i];
                array[i] = array[j];
                array[j] = k;
                j += 1;
            }
        }
        array[top] = array[j];
        array[j] = pivot;
        return j;
    }
}
