package MyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 说明：数组有关的工具类
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
        if (stringBuilder.lastIndexOf(",") == stringBuilder.length() - 1){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
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

    /** 根据值划分数组 */
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

    /** 获取每个桶的值的范围 */
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

    /** 获取每个桶中元素的个数 */
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

    /** 合并数组 */
    public static int[] mergedArray(int[]... arrays){
        int newSize = 0;
        int index = 0;
        for (int[] array : arrays){
            newSize += array.length;
        }
        int[] newArray = new int[newSize];
        for (int[] array : arrays) {
            System.arraycopy(array ,0 ,newArray ,index ,array.length);
            index += array.length;
        }
        return newArray;
    }
    /** 统计每个值之前的值的个数 */
    public static int[] getCountingSortCount(int[] array){
        int max = ArrayUtils.getMax(array);
        int min = ArrayUtils.getMin(array);
        int[] bucketRange = ArrayUtils.getBucketRange(array, min, max, (max - min + 1));
        int[] bucketElementNumber = ArrayUtils.getBucketElementNumber(array, bucketRange);
        for (int i = 1; i < bucketElementNumber.length; i++) {
            bucketElementNumber[i] += bucketElementNumber[i - 1];
        }
        return bucketElementNumber;
    }

    /** 计数排序的计数 */
    /*public static int[] getCountingSortCount(int[] array){
        int max = ArrayUtils.getMax(array);
        int min = ArrayUtils.getMin(array);
        int[] bucketRange = ArrayUtils.getBucketRange(array, min, max, (max - min + 1));
        int[] bucketElementNumber = ArrayUtils.getBucketElementNumber(array, bucketRange);
        for (int i = 1; i < bucketElementNumber.length; i++) {
            bucketElementNumber[i] += bucketElementNumber[i - 1];
        }
        return bucketElementNumber;
    }*/


    /** 将int数组转换为等长的String数组， */
    public static String[] intArrayTransformEquilongStringArray(int... array){
        int max = getMax(array);
        int size = String.valueOf(max).length();
        StringBuilder stringBuilder = new StringBuilder();
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (stringBuilder.length() < size){
                for (int j = stringBuilder.length(); j < size; j++) {
                    stringBuilder.insert(0,"0");
                }
            }
            newArray[i] = stringBuilder.toString();
            stringBuilder.delete(0 ,size);
        }
        return newArray;
    }

    /** 将int数组转换为等长的String数组， */
    public static int[] stringArrayTransformIntArray(String... array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Integer.valueOf(array[i]);
        }
        return newArray;
    }

    public static boolean equals(int[] object1 ,int[] object2){
        boolean flag;
        if (object1.length != object2.length){ return false;}
        if (object1.getClass() != object2.getClass()){return false;}
        for (int i : object1){
            flag = false;
            for (int j : object2){
                if (i == j){
                    flag = true;
                    break;
                }
            }
            if (!flag){return false;}
        }
        return true;
    }

    /** 三数取中 */
    public int getPivotIndex(int[] array ,int low ,int top){
        int[] ints = new int[3];
        ints[0] = array[low];
        ints[1] = array[(low + top) / 2];
        ints[2] = array[top];
        int max = getMax(ints);
        int min = getMin(ints);
        if (min == max){
            return low;
        }
        for (int i = 0; i < 3; i++) {
            if (ints[i] > min && ints[i] < max){
                switch (i){
                    case 0:
                        return low;
                    case 1:
                        return (low + top) / 2;
                    default:
                        return top;
                }
            }
        }
        return top;
    }

    /** 随机 */
    public int getRandomPivotIndex(int[] array ,int low ,int top){
        Random random = new Random();
        return random.nextInt(top - low) + low;
    }

}
