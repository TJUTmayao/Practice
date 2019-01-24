package Sort.RadixSort;

import MyUtils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：基数排序 稳定 0(n)
 *
 * @Auther: 11432_000
 * @Date: 2019/1/19 09:47
 * @Description:
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64};
        String[] strings = radixSort(array);
        int[] ints = ArrayUtils.stringArrayTransformIntArray(strings);
        System.out.println(ArrayUtils.intArrayToString(ints));
        System.out.println(ArrayUtils.equals(ints ,array));
    }
    /** LSD 最低位优先法 */
    public static String[] radixSort(int[] array){
        String[] strings = ArrayUtils.intArrayTransformEquilongStringArray(array);
        int elementLength = strings[0].length();
        for (int i = elementLength - 1; i >= 0; i--) {
           strings = countingSortMain(strings, i);
        }
        return strings;
    }

    /** 对其中一位进行计数排序 稳定版 */
    public static String[] countingSortMain(String[] array ,int bit){
        char aChar;
        int index;
        char min = getMin(array, bit);
        String[] newArray = new String[array.length];
        //获取桶
        char[] bucketRange = getBucketRange(array, bit);
        //统计每个桶元素的个数
        int[] bucketElementNumber = getBucketElementNumber(array, bucketRange, bit);
        getCountingSortCount(bucketElementNumber);
        //计数排序
        for (int i = array.length - 1; i >= 0 ;i--){
            aChar = array[i].charAt(bit);
            index = (bucketElementNumber[aChar - min]--) - 1;
            newArray[index] = array[i];
        }
        return newArray;
    }

    /** 获取每个桶的值的范围 */
    public static char[] getBucketRange(String[] array ,int bit){
        char max = getMax(array ,bit);
        char min = getMin(array, bit);
        int number = max - min + 1;
        char[] ranges = new char[number + 1];
        for (int i = 0; i < number; i++) {
            ranges[i] =(char)(min + i);
        }
        return ranges;
    }

    /** 获取每个桶中元素的个数 */
    public static int[] getBucketElementNumber(String[] array ,char[] ranges ,int bit){
        int[] rangeNumber = new int[ranges.length - 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = rangeNumber.length - 1; j >= 0; j--) {
                if (array[i].charAt(bit) >= ranges[j]){
                    rangeNumber[j] ++;
                    break;
                }
            }
        }
        return rangeNumber;
    }

    public static char getMax(String[] array ,int bit){
        char max = array[0].charAt(bit);
        for (int i = 0; i < array.length; i++) {
            char charI = array[i].charAt(bit);
            if (max < charI){
                max = charI;
            }
        }
        return max;
    }

    public static char getMin(String[] array ,int bit){
        char min = array[0].charAt(bit);
        for (int i = 0; i < array.length; i++) {
            char charI = array[i].charAt(bit);
            if (min > charI){
                min = charI;
            }
        }
        return min;
    }

    /** 统计每个值之前的值的个数 */
    private static void getCountingSortCount(int[] array){
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }
}


