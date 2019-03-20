package DataStructures.Graph;

/**
 * 说明：邻接表节点
 *
 * @Auther: 11432_000
 * @Date: 2019/2/8 10:07
 * @Description:
 */
public class GraphNode {

    /** 权值 */
    public int weight;
    /** 其他连接点 */
    public GraphNode next;
    /** 顶点的唯一标志 */
    public int key;
    /** 入度 */
    public int inDegree = 0;
    /** 出度 */
    public int outDegree = 0;

    public GraphNode(int key,int weight) {
        this.weight = weight;
        this.key = key;
    }

    public GraphNode() {
    }
}
