package DataStructures.BinaryTree;

/**
 * 说明：树的节点
 *
 * @Auther: 11432_000
 * @Date: 2019/1/29 10:30
 * @Description:
 */
public class TreeNode<T> {
    /** 数据 */
    public Object data;
    /** 左节点 */
    public TreeNode<T> left;
    /** 右节点 */
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode() {
    }
}
