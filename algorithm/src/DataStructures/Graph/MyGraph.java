package DataStructures.Graph;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/2/8 10:12
 * @Description:
 */
public class MyGraph {
    /**
     * 邻接表
     */
    private GraphNode[] graph;
    /**
     * 顶点个数
     */
    private int size;
    /**
     * 逆邻接表
     */
    private GraphNode[] inverseGraph = null;
    /**
     * 是否为有向图
     */
    public boolean isDirectional;

    public MyGraph(boolean isDirectional) {
        this.graph = new GraphNode[16];
        if (isDirectional) {
            this.inverseGraph = new GraphNode[16 + 1];
        }
        this.isDirectional = isDirectional;
        this.size = 0;
    }

    /**
     * 添加一个新节点
     */
    public void add(int key, int weight) {
        if (findNodeIndex(key ,this.graph) != -1){
            throw new RuntimeException("节点的key重复");
        }
        GraphNode newNode = new GraphNode(key, weight);
        this.graph[this.size] = newNode;
        if (isDirectional) {
            this.inverseGraph[this.size] = new GraphNode(key, weight);
        }
        this.size ++;
    }
    /** 创建边 */
    public void relation(int key1, int key2) {
        if (key1 >= this.size || key2 >= this.size) {
            throw new RuntimeException("顶点不存在!");
        }
        if (this.graph[key1] == null || this.graph[key2] == null) {
            throw new RuntimeException("顶点不存在!");
        }
        if (key1 == key2){return;}
        if (isRelation(key1,key2)){return;}
        //有向图
        if (isDirectional) {
            //添加到有向表
            addRelation(key1, key2, this.graph);
            //添加到逆向表
            addRelation(key2, key1, this.inverseGraph);
        }
        //无向图
        if (!isDirectional){
            //双向添加
            addRelation(key1, key2, this.graph);
            addRelation(key2, key1, this.graph);
        }
    }

    public boolean isRelation(int key1,int key2){
        GraphNode node = this.graph[key1];
        while (node.next != null){
            node = node.next;
            if (node.key == key2){
                return true;
            }
        }
        return false;
    }

    /**
     * key1指向key2 添加有向边
     */
    private void addRelation(int key1, int key2, GraphNode[] table) {
        GraphNode start = table[key1];
        GraphNode end = table[key2];
        while (start.next != null) {
            start = start.next;
        }
        start.next = new GraphNode(key2, end.weight);
        start.outDegree ++;
        end.inDegree ++;
    }
    /** 删除节点 */
    public void delete(int key){
        if (isDirectional){
            remove(key ,this.graph ,this.inverseGraph);
            remove(key ,this.inverseGraph ,this.graph);
        }else {
          remove(key ,this.graph ,null);
        }
        this.size --;
    }

    /** 删除表中该节点的所有信息 */
    private void remove(int key ,GraphNode[] nodes1 ,GraphNode[] nodes2){
        int nodeIndex = findNodeIndex(key, nodes1);
        //先将要删除的节点交换至末尾
        GraphNode casual = nodes1[nodeIndex];
        nodes1[nodeIndex] = nodes1[this.size - 1];
        nodes1[this.size - 1] = casual;
        if (isDirectional || nodes2 == null){
            nodes2 = nodes1;
        }
        GraphNode node = nodes1[this.size - 1];
        int i = 0;
        GraphNode[] outs = new GraphNode[node.outDegree];
        while (node.next != null){
            outs[i] = node.next;
            node = node.next;
        }
        //删除该节点
        nodes1[nodeIndex] = null;
        //删除连接该节点的节点的链表中的该节点
        for (GraphNode oneOf : outs){
            GraphNode tar = nodes2[findNodeIndex(oneOf.key, nodes2)];
            while (tar.next != null){
                if (tar.next.key == key){
                    tar.next = tar.next.next;
                }
            }
        }
    }

    /** 查找节点的索引 */
    public int findNodeIndex(int key ,GraphNode[] nodes){
        for (int i = 0; i < size; i++) {
            if (nodes[i].key == key){
                return i;
            }
        }
        return -1;
    }
    public int findNodeIndex(int key){
        return findNodeIndex(key ,this.graph);
    }


    public void showAll(){
        System.out.println("---------邻接表-----------");
        for (int i = 0; i < this.size; i++) {
            GraphNode node = this.graph[i];
            System.out.print(node.key + "-->");
            while (node.next != null){
                System.out.print(node.next.key +",");
                node = node.next;
            }
            System.out.println();
        }
    }

    public GraphNode getNode(int index){
        return this.graph[index];
    }

    public int getSize() {
        return size;
    }
}


