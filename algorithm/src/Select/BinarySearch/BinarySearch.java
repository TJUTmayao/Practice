package Select.BinarySearch;

/**
 * 说明：简单二分查找
 *
 * @Auther: 11432_000
 * @Date: 2019/1/22 10:26
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(binarySearch(array ,array.length ,5));
    }

    /** 简单二分查找 */
    public static int binarySearch(int[] array,int length, int target){
        int low ,top, mid;
        low = 0;
        top = length - 1;
        while(low <= top){
            mid = (low + ((top - low) >> 1));
            if (array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                low = mid + 1;
            }else {
                top = mid - 1;
            }
        }
        return -1;
    }
}
