package Others.DynamicProgramming;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/16 09:18
 * @Description:
 */
public class YangHuiSanJiao {
    TreeNode[] tree;
    int last = 0;
    int layer = 1;
    int layerMax = 0;

    public YangHuiSanJiao(int size) {
        this.tree = new TreeNode[size];
    }

    public void add(int... data){
        for (int i = 0; i < data.length; i++) {
            TreeNode treeNode = new TreeNode(data[i]);
            this.layerMax ++;
            if (this.layerMax > this.layer){
                this.layer ++;
                this.layerMax = 1;
            }
            treeNode.setLeft(this.last + this.layer);
            treeNode.setRight(this.last + this.layer + 1);
            this.tree[this.last ++] = treeNode;
        }
    }

    public void show(){
        for (TreeNode i:this.tree){
            System.out.println(i.data + " left:" + i.left + " right:" + i.right + "\t");
        }
    }
}
