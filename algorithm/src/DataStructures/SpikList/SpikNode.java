package DataStructures.SpikList;

/**
 * 说明：跳表节点
 *
 * @Auther: 11432_000
 * @Date: 2019/1/24 09:33
 * @Description:
 */
public class SpikNode{
    public int value;
    public SpikNode[] nexts = new SpikNode[SpikList.MAX_LEVEL];
    public int haveLevel;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{data:");
        stringBuilder.append(value);
        stringBuilder.append(",levels:");
        stringBuilder.append(haveLevel);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


}
