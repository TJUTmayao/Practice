package DataStructures.BinaryTree;

import com.sun.istack.internal.NotNull;

/**
 * 说明：引用式结构练习
 *
 * @Auther: 11432_000
 * @Date: 2019/1/29 10:34
 * @Description:
 */
public class MyBinaryTree<T> {

    /** 根节点 */
//    private TreeNode<T> root;
    private TreeNode root;
    /** 树高度 */
    private int height;

    public MyBinaryTree() {
        init();
    }


    private void init(){
        TreeNode<String> node01 = new TreeNode<>("A");
        TreeNode<String> node02 = new TreeNode<>("B");
        TreeNode<String> node03 = new TreeNode<>("C");
        TreeNode<String> node04 = new TreeNode<>("D");
        TreeNode<String> node05 = new TreeNode<>("E");
        TreeNode<String> node06 = new TreeNode<>("F");
        TreeNode<String> node07 = new TreeNode<>("G");
        node01.left = node02;
        node01.right = node03;
        node02.left = node04;
        node02.right = node05;
        node03.left = node06;
        node03.right = node07;
        this.root = node01;
    }

    public void add(T data){

    }

    /** 前序遍历查找 */
    public TreeNode<T> find(@NotNull T data , TreeNode<T> node){
        if (node.left == null && node.right == null){return null;}
        if (data.equals(node.data)){return node;}
        if (node.left != null){
            TreeNode<T> left = find(data, node.left);
            if (left != null){return left;}
        }
        if (node.right != null){
            TreeNode<T> right = find(data, node.right);
            if (right != null){return right;}
        }
        return null;
    }

    public void showAll(){
        TreeNode root = this.root;
        System.out.println("-------前序遍历-------");
        firstTraversals(root);
        System.out.println();
        root = this.root;
        System.out.println("-------中序遍历-------");
        middleTraversals(root);
        System.out.println();
        root = this.root;
        System.out.println("-------后序遍历-------");
        lastTraversals(root);
        System.out.println();
        root = this.root;
        System.out.println("-------层遍历-------");
        TreeNode[] treeNodes = new TreeNode[7];
        treeNodes[0] = root;
        floorTraversals( treeNodes,0 ,1);
        System.out.println();
    }

    /** 前序遍历 */
    public void firstTraversals(TreeNode start){
        if (start == null){return;}
        System.out.print(start.data + "\t");
        firstTraversals(start.left);
        firstTraversals(start.right);
        return;
    }
    /** 中序遍历 */
    public void middleTraversals(TreeNode start){
        if (start == null){return;}
        middleTraversals(start.left);
        System.out.print(start.data + "\t");
        middleTraversals(start.right);
        return;
    }

    /** 后序遍历 */
    public void lastTraversals(TreeNode start){
        if (start == null){return;}
        lastTraversals(start.left);
        lastTraversals(start.right);
        System.out.print(start.data + "\t");
        return;
    }

    /** 层遍历 */
    public void floorTraversals(TreeNode[] queue ,int top ,int tail){
        TreeNode node = queue[top];
        top = (top + 1) % queue.length;
        if (node == null){return;}
        System.out.print(node.data + "\t");
        queue[tail] = node.left;
        tail = (tail + 1) % queue.length;
        queue[tail] = node.right;
        tail = (tail + 1) % queue.length;
        floorTraversals(queue ,top ,tail);
    }
}
