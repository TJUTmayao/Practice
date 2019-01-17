package MergeSort;

import MyUtils.ArrayUtils;

/**
 * 说明：归并排序
 *
 * @Auther: 11432_000
 * @Date: 2019/1/17 09:00
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] randomInts = {12,43,77,32,78,23,24,87,11,86,44,5,21,38,27,3};
        System.out.println(ArrayUtils.intArrayToString(randomInts));
        mergeSortA(randomInts ,0 ,randomInts.length - 1);
        System.out.println(ArrayUtils.intArrayToString(randomInts));
        System.out.println(ArrayUtils.isOrder(randomInts));
        mergeSortB(randomInts ,0 ,randomInts.length - 1);
        System.out.println(ArrayUtils.intArrayToString(randomInts));

    }

    public static void mergeSortA(int[] randomInts ,int low ,int top){
        if (low >= top){ return; }
        int intermediateValue = (low + top) / 2;
        //递归
        mergeSortA(randomInts ,low ,intermediateValue);
        mergeSortA(randomInts ,intermediateValue + 1 ,top);
        //排序
        mergeSortB(randomInts ,low ,intermediateValue);
        mergeSortB(randomInts ,intermediateValue + 1,top);
        //合并
        merge(randomInts, low, intermediateValue, intermediateValue + 1, top);
    }
    /** 排序数组 */
    public static void mergeSortB(int[] randomInts ,int low ,int top){
        int k;
        for (int i = low + 1 ,j = low; i <= top; i++,j++) {
            int randomInt = randomInts[i];
            for (k = j; k >= low; k--) {
                if (randomInts[k] <= randomInt){
                    break;
                }
                randomInts[k + 1] = randomInts[k];
            }
            randomInts[k + 1] = randomInt;
        }
    }
    /** 合并数组 */
    public static void merge(int[] array ,int low1 ,int top1 ,int low2,int top2){
        int size = top2 - low1 + 1;
        int[] newArray = new int[size];
        int k = 0;
        int i,j;
        for (i = low1,j = low2; i <= top1 && j <= top2;) {
            if (array[i] <= array[j]){
                newArray[k] = array[i];
                k ++;
                i ++;
            }else {
                newArray[k] = array[j];
                k ++;
                j ++;
            }
        }
        if (i <= top1){
            System.arraycopy(array ,i ,newArray ,k ,top1 - i + 1);
        }
        else if (j <= top2){
            System.arraycopy(array ,j ,newArray ,k ,top2 - j + 1);
        }
        System.arraycopy(newArray ,0 ,array ,low1 ,newArray.length);
    }

}
