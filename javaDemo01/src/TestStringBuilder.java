/**
 * 说明：StringBuilder 线程不安全，高效    StringBuffer 线程安全，相对不高效
 *
 * @Auther: 11432_000
 * @Date: 2018/10/15 14:04
 * @Description:
 */
public class TestStringBuilder {

    public static void main(String[] arg){
        StringBuilder stringBuilder = new StringBuilder();
        /* 在末尾添加 支持多种数据类型自动转换 */
        stringBuilder.append(123456);
        /* 在指定位置<前>插入，支持多种数据类型自动转换 */
        stringBuilder.insert(2,"mayao");
        /* 删除两个索引之间的字符串 闭包*/
        stringBuilder.delete(2,7);
        /* 替换两个索引之间的字符串 */
        stringBuilder.replace(1,1,"sdda");
        /* 将字符串倒置 */
        stringBuilder.reverse();
        System.out.println(stringBuilder);

    }
}
