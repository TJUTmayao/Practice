package Others.StringMatching;

/**
 * 说明：KMP算法
 *
 * @Auther: 11432_000
 * @Date: 2019/3/20 17:22
 * @Description:
 */
public class KMP {

    /** 构造失效函数 */
    private static void  initFailureFunction(char[] patternString ,int patternSize,int[] failureFunction){
        for (int i = 0; i < failureFunction.length; i++) {
            failureFunction[i] = -1;
        }
        for (int i = 1; i <= patternSize; i++) {
            int maxPrefixSubstringEndIndex = failureFunction[i - 1];
            //找到次长前缀子串，注意次长前缀子串不是最长前缀子串 - 1
            while(maxPrefixSubstringEndIndex != -1){
                if (patternString[maxPrefixSubstringEndIndex + 1] == patternString[i]){
                    break;
                }
                maxPrefixSubstringEndIndex = failureFunction[maxPrefixSubstringEndIndex];
            }
            //如果前缀子串的下一个元素和好前缀的最后一个元素相同
            if (maxPrefixSubstringEndIndex + 1 != i - 1 && patternString[maxPrefixSubstringEndIndex + 1] == patternString[i - 1]){
                maxPrefixSubstringEndIndex ++;
            }
            failureFunction[i] = maxPrefixSubstringEndIndex;
        }
    }

    /** KMP算法 */
    public static int kmp(char[] mainString,int mainSize ,char[] patternString ,int patternSize){
        int[] failureFunction = new int[patternSize + 1];
        initFailureFunction(patternString,patternSize,failureFunction);
        int moveLength,patternStart;
        int maxPrefixEndIndex;
        patternStart = 0;
        moveLength = 0;
        for (int i = 0; i <= mainSize - patternSize;) {
            maxPrefixEndIndex = -1;
            int patternBadIndex = getPatternBadIndex(mainString, mainSize, patternString, patternSize,
                    i + patternStart,patternStart);
            //没找到坏字符，则匹配成功
            if (patternBadIndex == -1){
                return i;
            }
            if (patternBadIndex != 0){
                //获取模式串的前缀子串X中——X的前缀子串A和X的后缀子串B相匹配的子串中最长的A的末尾下标
                maxPrefixEndIndex = failureFunction[patternBadIndex];
                //如果么有找到，模式串移动好前缀长度
                if (maxPrefixEndIndex == -1){
                    moveLength = patternBadIndex;
                }
                //如果找到，模式串移动 好前缀长度 - 找到的前缀子串 的长度
                if (maxPrefixEndIndex != -1){
                    moveLength = patternBadIndex - (maxPrefixEndIndex + 1);
                }
            }else {
                moveLength = 1;
            }
            //从找到的前缀子串之后开始找。
            patternStart = maxPrefixEndIndex + 1;
            i += moveLength;
        }
        return -1;
    }

    /** 查找坏字符在模式串中的位置（好前缀长度）*/
    private static int getPatternBadIndex(char[] mainString,int mainSize ,char[] patternString ,int patternSize ,
                                          int mainStart,int patternStart){
        for (int i = mainStart ,j = patternStart; i < mainSize && j < patternSize; i++,j++) {
            if(mainString[i] != patternString[j]){
                return j;
            }
        }
        return -1;
    }

    /** KMP算法 */
    public static int kmp(String main,String pattern) {
        char[] mainString = main.toCharArray();
        char[] patternString = pattern.toCharArray();
        return kmp(mainString,mainString.length,patternString,patternString.length);
    }
}
