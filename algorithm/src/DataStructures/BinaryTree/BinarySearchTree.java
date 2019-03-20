package DataStructures.BinaryTree;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 说明：二叉查找树(不平衡)，支持重复key，将其作为相同节点的右子树的最左节点
 *
 * @Auther: 11432_000
 * @Date: 2019/1/29 15:51
 * @Description:
 */
public class BinarySearchTree<T> {

    /** 根节点 */
    private TreeNode2<T> root;
    /** 标志树是否改变 */
    private boolean isChange = false;
    /** 高度 */
    private int height = 0;

    public BinarySearchTree() {

    }

    /** 根据key递归查找所有的元素 */
    public List<TreeNode2<T>> get(int key){
        TreeNode2<T> root = this.root;
        List<TreeNode2<T>> list = new ArrayList<>();
        findNode(key, root ,list);
        return list;
    }

    /** 根据key递归查找所有的元素 */
    private void findNode(int key , TreeNode2<T> start,List<TreeNode2<T>> list){
        if (start == null){return;}
        //查找所有等于key的节点
        if (key == start.key){
            list.add(start);
            findNode(key ,start.right ,list);
        }else if(key > start.key){
            findNode(key ,start.right ,list);
        }else {
            findNode(key ,start.left ,list);
        }
    }

    public void put(int key ,T data) {
        TreeNode2<T> root = this.root;
        TreeNode2<T> newNode = new TreeNode2<>(key,data);
        putOnTree(newNode ,root);
        this.isChange = true;
    }

    /** 将一个元素插入树中 */
    private void putOnTree(TreeNode2<T> newNode ,TreeNode2<T> start){
        //如果是第一个节点
        if (start == null){
            this.root = newNode;
            return;
        }
        //判断是否可以插入
        if (newNode.key < start.key && start.left == null){
            start.left = newNode;
            newNode.parent = start;
            return;
        } else if (newNode.key >= start.key && start.right == null){
            start.right = newNode;
            newNode.parent = start;
            return;
        }
        //小于放左边，大于等于放右边
        if (newNode.key < start.key){
            putOnTree(newNode ,start.left);
        }
        if (newNode.key >= start.key){
            putOnTree(newNode,start.right);
        }
    }

    public void remove(int key){
        deleteNodes(key);
        this.isChange = true;
    }

    /** 从树中删除集合内的所有key对应的节点 */
    private void deleteNodes(int key){
        List<TreeNode2<T>> treeNodes = get(key);
        if (treeNodes == null || treeNodes.size() == 0){
            return;
        }
        int size = treeNodes.size();
        for (int i = 0; i < size; i++) {
            deleteNode(treeNodes.get(0));
            treeNodes = get(key);
        }
    }

    /** 从树中删除一个指定的节点 */
    private void deleteNode(TreeNode2<T> node){
        TreeNode2<T> thisMin = null;
        //被删除节点有两个子节点时
        if (node.right != null && node.left != null){
            thisMin = getThisMin(node.right);
            delete(thisMin);
            node.data = thisMin.data;
            node.key = thisMin.key;
            return;
        }
        //被删除节点只有一个子节点时
        else if (node.right != null || node.left != null){
            delete(node);
            return;
        }
        //被删除节点没有子节点时
        delete(node);
    }

    /** 删除一个节点 */
    private void delete(TreeNode2<T> node){
        TreeNode2<T> sonTree = null;
        TreeNode2<T> parent = null;
        boolean isLeft = false,isRight = false;
        //获取被删除节点的父节点
        if (node.parent != null){
            parent = node.parent;
            node.parent = null;
        }
        //将被删除节点的父节点指向被删除节点的引用置为空,并记录左右
        if (parent.left == node){
            parent.left = null;
            isLeft = true;
        }else if (parent.right == node){
            parent.right = null;
            isRight = true;
        }
        //获取被删除节点的子节点，并将被删除节点的子节点引用置为空
        if (node.left != null){
            sonTree = node.left;
            node.left = null;
        }else if (node.right != null){
            sonTree = node.right;
            node.right = null;
        }
        //将被删除节点的子节点的父节点设置为被删除节点的父节点
        if (sonTree != null){
            sonTree.parent = parent;
        }
        //将被删除节点的父节点的子节点指向被删除节点的子节点
        if (parent != null){
            if (isLeft){
                parent.left = sonTree;
            }
            if (isRight){
                parent.right = sonTree;
            }
        }
    }

    /** 找到被删除节点的右子树的最小节点 */
    private TreeNode2<T> getThisMin(TreeNode2<T> start){
        if (start.left == null){return start;}
        TreeNode2<T> thisMin = null;
        thisMin = getThisMin(start.left);
        return thisMin;
    }

    /** 中序遍历 */
    private void middleTraversals(TreeNode2<T> start){
        if (start == null){return;}
        middleTraversals(start.left);
        System.out.print("{Key:" + start.key + ",Data:" + start.data + "}" + "\t");
        middleTraversals(start.right);
        return;
    }

    public void show(){
        TreeNode2<T> root = this.root;
        System.out.println("-------中序遍历-------");
        middleTraversals(root);
        System.out.println();
    }

    /** 获取树的高度 */
    public int height(){
        TreeNode2<T> start  = this.root;
        if (this.isChange){
            this.height = getHeight(start);
        }
        return this.height;
    }


    /** 计算树的高度 */
    public int getHeight(TreeNode2<T> start){
        int rightHeight = -1;
        int leftHeight = -1;
        if (start.left != null){
            leftHeight = getHeight(start.left) + 1;
        }
        if (start.right != null){
            rightHeight = getHeight(start.right) + 1;
        }
        if (rightHeight > 0 || leftHeight > 0){
            if (rightHeight > leftHeight){
                return rightHeight;
            }else {
                return leftHeight;
            }
        }else {
            return 1;
        }
    }
}
