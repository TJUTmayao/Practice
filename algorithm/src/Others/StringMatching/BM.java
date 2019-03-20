package Others.StringMatching;

/**
 * 说明：BM算法
 *
 * @Auther: 11432_000
 * @Date: 2019/3/20 09:48
 * @Description:
 */
public class BM {

    private static final int HASH_TABLE_SIZE = 256;

    /** 坏字符hash表构建 存储模式串中每种字符最后一次出现的位置 */
    public static void createBadCharHash(char[] array,int charsSize ,int[] hash){
        for (int i = 0; i < hash.length; i++) {
            hash[i] = -1;
        }
        //记录每种字符最后一次出现的位置
        for (int i = 0; i < charsSize ; i++) {
                hash[(int)array[i]] = i;
        }
    }

    /** 获取坏字符的位置  */
    private static int getIndexByBadChar(char[] mainString ,int mainSize , char[] patternString,
        int patternSize,int startIndex){
        int mainIndex = startIndex;
        int patternIndex = patternSize - 1;
        if (mainIndex <= mainSize - patternSize){
            //将模式串和主串从后向前匹配
            for (; patternIndex >= 0 ; patternIndex--) {
                if (mainString[mainIndex + patternIndex] != patternString[patternIndex]){break;}
            }
        }else {return -1;}
        return patternIndex;
    }

    /** 获取好后缀规则移动的长度 */
    private static int getLengthByGoodSuffix(int patternSize, int[] suffixHash,
                                                    boolean[] prefix,int badIndex ){
        int size = patternSize -(badIndex + 1);
        if (suffixHash[size] != -1){
            return badIndex - suffixHash[size] + 1;
        }else if (suffixHash[size] == -1){
            for (int i = size - 1; i >= 1; i--) {
                if (prefix[i]){
                    return patternSize - i;
                }
            }
        }
        return patternSize;
    }

    /** suffixIndex：存储模式串中最后一个与好后缀匹配的子串的起始位置
     *  prefix：标识和好后缀匹配的模式串的前缀子串。
     * */
    private static void getSuffixHashAndPrefixHash(char[] array,int arraySize ,int[] suffixIndex,boolean[] prefix){
        //初始化数组
        for (int i = 0; i < suffixIndex.length; i++) {
            suffixIndex[i] = -1;
            prefix[i] = false;
        }
        //记录前缀子串和模式串的匹配的起始下标
        int patternEnd,prefixEnd;
        //遍历模式串的所有前缀子串
        for (int i = 0; i < arraySize - 1; i++) {
            patternEnd = arraySize - 1;
            prefixEnd = i;
            //求前缀子串和模式串的公共后缀子串（即与 模式串的后缀子串 匹配的 模式串的子串）
            while (prefixEnd >= 0){
                if (array[patternEnd] != array[prefixEnd]){
                    break;
                }
                patternEnd --;
                prefixEnd --;
                //子串长度作为下标记录最后一个与 模式串的后缀子串 匹配的 模式串的子串 的起始下标
                suffixIndex[i - prefixEnd] = prefixEnd + 1;
            }
            //模式串的前缀子串和后缀子串匹配，记录为true，下标为子串长度
            if (prefixEnd < 0){
                prefix[i - prefixEnd] = true;
            }
        }
    }

    /** bm算法：
     * 1、先通过坏字符规则获取坏字符在模式串的下标
     * 2、若下标为-1，表示已找到匹配字符串，返回起始下标
     * 3、否则，若有好后缀，通过suffixIndex表获取起始下标，返回（坏字符下标 - 起始下标 + 1 ），若起始下标为-1，则通过prefix表
     *    查找是否有前缀子串与好后缀的后缀子串相同，若有返回 模式串长度 - 前缀子串长度 ，否则返回模式串长度。
     * 4、计算坏字符下标对应在主串中的位置badIndex
     * 5、从坏字符Hash表中取出badIndex对应字符对应的下标，并计算位移量
     * 6、取好后缀和坏字符中较大的一方，然后移动模式串
     *
     *    */
    public static int bm(char[] mainString ,int mainSize ,char[] patternString,int patternSize){
        int[] badCharHash = new int[HASH_TABLE_SIZE];
        createBadCharHash(patternString ,patternSize ,badCharHash);
        int[] suffixHash = new int[patternSize + 1];
        boolean[] prefix = new boolean[patternSize + 1];
        getSuffixHashAndPrefixHash(patternString ,patternSize,suffixHash,prefix);
        int mainIndex = 0;
        int lengthByGoodSuffix,badCharLength,mainBadIndex;
        while (mainIndex <= mainSize - patternSize){
            lengthByGoodSuffix = badCharLength = 0;
            int badIndex = getIndexByBadChar(mainString, mainSize, patternString, patternSize, mainIndex);
            if (badIndex != -1 && badIndex + 1 != patternSize){
                lengthByGoodSuffix = getLengthByGoodSuffix(patternSize, suffixHash, prefix, badIndex);
            }else if (badIndex == -1){
                return mainIndex;
            }
            //获取主串中坏字符的下标
            mainBadIndex = mainIndex + badIndex;
            //坏字符规则要移动的长度
            badCharLength = (badIndex - badCharHash[(int)mainString[mainBadIndex]]);
            //将模式串向后移动，使模式串的出现的最后一个坏字符与主串的坏字符对齐
            mainIndex += Math.max(lengthByGoodSuffix,badCharLength);
        }
        return -1;
    }

    public static int bm(String mainString ,String patternString){
        char[] main = mainString.toCharArray();
        char[] pattern = patternString.toCharArray();
        return bm(main, main.length, pattern, pattern.length);
    }
}
