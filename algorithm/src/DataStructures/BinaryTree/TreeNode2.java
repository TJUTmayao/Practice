package DataStructures.BinaryTree;

/**
 * 说明：树的节点
 *
 * @Auther: 11432_000
 * @Date: 2019/1/29 10:30
 * @Description:
 */
public class TreeNode2<T> {

    /** Key */
    public int key;
    /** 数据 */
    public Object data;
    /** 左节点 */
    public TreeNode2<T> left;
    /** 右节点 */
    public TreeNode2<T> right;
    /** 父节点 */
    public TreeNode2<T> parent;

    public TreeNode2(T data) {
        this.data = data;
    }

    public TreeNode2() {
    }

    public TreeNode2(int key, Object data) {
        this.key = key;
        this.data = data;
    }
}
