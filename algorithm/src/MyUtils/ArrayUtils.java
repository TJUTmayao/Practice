package MyUtils;

import java.util.Random;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/17 09:01
 * @Description:
 */
public class ArrayUtils {

    public static int[] getRandomInts(int min ,int max ,int number){
        /**
         *
         * 功能描述: 根据条件获取一个整数数组
         *
         * @param: [min, max, number]
         * @return: int[]
         * @auther: 11432_000
         * @date: 2019/1/17 9:10
         */
        int[] array = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = min + random.nextInt(max - min);
        }
        System.out.println(intArrayToString(array));
        return array;
    }

    public static String intArrayToString(int[] array){
        /**
         *
         * 功能描述: 将数组转换为字符串
         *
         * @param: [array]
         * @return: java.lang.String
         * @auther: 11432_000
         * @date: 2019/1/17 11:18
         */
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i : array){
            stringBuilder.append(i + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static boolean checkIntArrayCompleteness(int[] array1 ,int... array2){
        /**
         *
         * 功能描述: 检查两个数组中的元素是否一致
         *
         * @param: [array1, array2]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2019/1/17 11:19
         */
        boolean isHave;
        if (array1.length != array2.length){ return false; }
        for (int i : array1){
            isHave = false;
            for (int j : array2){
                if (i == j){
                    isHave = true;
                    break;
                }
            }
            if (!isHave){ return false; }
        }
        return true;
    }

    public static boolean isOrder(int... array){
        /**
         *
         * 功能描述: 检查数组是否有序
         *
         * @param: [array]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2019/1/17 11:20
         */
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static int getMax(int... array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static int getMin(int... array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

    public static int[][] getBucketsByValue(int[] array,int number){
        int min = getMin(array);
        int max = getMax(array);
        int[] bucketRange = getBucketRange(array, min, max, number);
        System.out.println("范围：" + intArrayToString(bucketRange));
        int[] bucketElementNumber = getBucketElementNumber(array, bucketRange);
        int[][] bucketArray = new int[number][];
        for (int i = 0; i < number; i++) {
            bucketArray[i] = new int[bucketElementNumber[i]];
        }
        int[] count = new int[number];
        for (int i = 0; i < array.length; i++) {
            for (int j = count.length - 1; j >= 0; j--) {
                if (array[i] >= bucketRange[j]){
                    bucketArray[j][count[j]++] = array[i];
                    break;
                }
            }
        }
        return bucketArray;
    }

    public static int[] getBucketRange(int[] array ,int min ,int max ,int number){
        int range = (min + max)/number;
        int[] ranges = new int[number + 1];
        for (int i = 0;; i++) {
            if (i == number){
                ranges[i] = max;
                break;
            }
            ranges[i] = min + range * i;
        }
        return ranges;
    }

    public static int[] getBucketElementNumber(int[] array ,int[] ranges){
        int[] rangeNumber = new int[ranges.length - 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = rangeNumber.length - 1; j >= 0; j--) {
                if (array[i] >= ranges[j]){
                    rangeNumber[j] ++;
                    break;
                }
            }
        }
        return rangeNumber;
    }

}
