package Sort.QuickSort;

import MyUtils.ArrayUtils;

/**
 * 说明：快速排序(快排) 平均O(nlogn)，最差O(n²) 不稳定 原地
 *
 * @Auther: 11432_000
 * @Date: 2019/1/18 08:29
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
        quickSort(array ,0 ,array.length - 1);
        System.out.println(ArrayUtils.isOrder(array));
        System.out.println(ArrayUtils.intArrayToString(array));
    }

    public static void quickSort(int[] array ,int low ,int top){
        if (low >= top){ return;}
        int pivotIndex = selectionSort(array, low, top);
        quickSort(array ,low ,pivotIndex - 1);
        quickSort(array ,pivotIndex + 1,top);
    }

    public static int selectionSort(int[] array ,int low ,int top){
        int i,j,transitionValue;
        int pivot = array[top];
        for (i = low ,j = low; i < top; i++) {
            if (array[i] <= pivot){
                transitionValue = array[i];
                array[i] = array[j];
                array[j] = transitionValue;
                j ++;
            }
        }
        array[top] = array[j];
        array[j] = pivot;
        return j;
    }
}
