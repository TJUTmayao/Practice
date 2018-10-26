/**
 * 说明：string方法测试
 *
 * @Auther: 11432_000
 * @Date: 2018/10/13 15:28
 * @Description:
 */
public class TestString {
    public static void main(String[] arg){
        String s = "mayao nb";
        /* 返回索引出字符的编码值 */
        int i = s.codePointAt(2);
        /* 返回索引之前的一个字符的编码值 */
        int i3 = s.codePointBefore(2);
        /* 比较字符串的大小 */
        int mayaonc = s.compareTo("mayaona");
        /* 返回两个字符串的差 */
        int i2 = s.compareToIgnoreCase("mayaona");
        /* 返回该编码对应字符的索引 */
        int i1 = s.indexOf(121);
        /* 根据指定字符分割字符串 */
        String[] os1 = s.split("o");
        /* 拼接字符串 */
        String zhengde = s.concat("zhengde");
        /* 判断字符串末尾是否有指定字符串 */
        boolean nb = s.endsWith("nb");
        /* 判断字符串是否为空 */
        boolean empty = s.isEmpty();
        /* 正则表达式匹配 */
        boolean yao = s.matches("[a-z]*");
        /* 仅当s.equals(m) s.intern() == m.intern() 返回字符串的规范化表达形式 */
        String intern = s.intern();
        /* 去除首尾空格 */
        String trim = s.trim();
        /* 将字符串转为大写 */
        String s1 = s.toUpperCase();
        /* 将字符串转换为小写 */
        String s2 = s.toLowerCase();
        /* 根据字符串算出的一个哈希值 （同一字符串多次调用结果相同）*/
        int i4 = s.hashCode();
        /* 截取字符串 不包含结尾位置的字符 */
        s.substring(1,3);

        System.out.println(s);
    }
}
