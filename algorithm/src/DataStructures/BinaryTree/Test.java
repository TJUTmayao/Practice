package DataStructures.BinaryTree;

import java.util.List;
import java.util.Random;

/**
 * 说明：二叉树测试
 *
 * @Auther: 11432_000
 * @Date: 2019/1/29 11:04
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        Random random = new Random();
        int j = 0;
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17};
        for (int i : array) {
            tree.put(i ,"M-" + j++);
        }
        List<TreeNode2<String>> treeNode2s = tree.get(20);
        for (TreeNode2 treeNode2 : treeNode2s){
            System.out.println(treeNode2.key + "-->" + treeNode2.data);
        }
        tree.remove(20);
        tree.remove(56);
        tree.show();
        System.out.println(array.length);
        System.out.println(tree.height());
    }
}
