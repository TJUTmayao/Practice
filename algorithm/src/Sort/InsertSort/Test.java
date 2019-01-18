package Sort.InsertSort;

import MyUtils.ArrayUtils;

/**
 * 说明：插入排序 O(n²) 稳定 原地
 *
 * @Auther: 11432_000
 * @Date: 2019/1/17 11:23
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] array = {49,10,44,95,53,52,45,56,50,39,71,11,16,21,88,99,22,48,1,80};
        insertSort(array);
        System.out.println(ArrayUtils.intArrayToString(array));
    }
    
    public static void insertSort(int... array){
        int k;
        for (int i = 1,j = 0; i < array.length; i++,j++) {
            int oneOfThem = array[i];
            for (k = j; k >= 0; k--) {
                if (oneOfThem >= array[k]){
                    break;
                }
                array[k + 1] = array[k];
            }
            array[k + 1] = oneOfThem;
        }
    }
}
