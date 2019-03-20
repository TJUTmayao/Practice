package DataStructures.Heap;

/**
 * 说明：堆节点
 *
 * @Auther: 11432_000
 * @Date: 2019/2/4 09:24
 * @Description:
 */
public class HeapNode<T> {

    /** 数据 */
    public Object data;
    /** 键值 */
    public int key;

    public HeapNode(int key,Object data) {
        this.data = data;
        this.key = key;
    }

    public HeapNode() {
    }
}
