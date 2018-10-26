
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/17 13:25
 * @Description:
 */
public class TestMap {

    public static void main(String[] arg){
        Map<String,String> map = new HashMap<>();
        map.put("20152176", "麻尧");
        map.put("20152175", "麻国栋");
        /* 返回map中所有key */
        Set<String> strings = map.keySet();
        /* 返回map中所有value */
        Collection<String> values = map.values();
        /* 检查map中是否有对应的key/value */
        boolean b = map.containsKey("20152176");
        boolean ma = map.containsValue("麻尧");
        /* 复制map */
        Map clone =(Map) ((HashMap<String, String>) map).clone();
        /* 返回map中所有的键值对 格式为key=value */
        Set<Map.Entry<String, String>> entries = map.entrySet();
        /* 输出entry */
        for (Map.Entry<String, String> en : entries){
            System.out.println(en.getKey() + en.getValue());
        }
        System.out.println(b);

    }
}
