package Select.BinarySearch;

/**
 * 说明：查找第一个等于给定值的元素
 *
 * @Auther: 11432_000
 * @Date: 2019/1/23 08:56
 * @Description:
 */
public class BinarySearch01 {
    public static void main(String[] args) {
        int[] array = {0,0,0,2,2,4,4,5,6,6,6,7,7,8,9};
        int i = binarySearch(array,array.length, 4);
        System.out.println(i);
    }

    public static int binarySearch(int[] array,int length , int target){
        int low,top,mid;
        low = 0;
        top = length - 1;
        while(low <= top){
            mid = ((top - low) >> 1) + low;
            if (array[mid] == target){
                if (mid == 0 || array[mid - 1] != target){ return mid; }
                else {
                   top = mid - 1;
                }
            }else if (array[mid] < target){
                low = mid + 1;
            }else {
                top = mid + 1;
            }
        }
        return -1;
    }
}
