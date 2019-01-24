package DataStructures.SpikList;

import java.util.Random;

/**
 * 说明：跳表
 *
 * @Auther: 11432_000
 * @Date: 2019/1/24 09:35
 * @Description:
 */
public class SpikList{

    /** 最大所引级 */
    protected static final int MAX_LEVEL = 16;
    /** 头结点 */
    private SpikNode head = new SpikNode();
    /** 索引级数（包括原链表） */
    private int level = 1;
    /** 随机函数 */
    private Random random = new Random();

    /** 获取要插入的最大层级 */
    private int getRandomLevel(){
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if(random.nextInt() % 2 == 1){
                level ++;
            }
        }
        return level;
    }

    //插入
    public void put(int value){
        int randomLevel = getRandomLevel();
        SpikNode newNode = new SpikNode();
        newNode.haveLevel = randomLevel;
        newNode.value = value;
        //记录每一级的索引。
        SpikNode[] updateIndex = new SpikNode[randomLevel];
        SpikNode node = this.head;
        //查找插入位置
        for (int i = randomLevel - 1; i >= 0 ; i--) {
            while (node.nexts[i] != null && node.nexts[i].value < value){
                node = node.nexts[i];
            }
            //记录每一级的位置
            updateIndex[i] = node;
        }
        //将该元素插入到每一级
        for (int i = 0 ; i < randomLevel; i++) {
            newNode.nexts[i] = updateIndex[i].nexts[i];
            updateIndex[i].nexts[i] = newNode;
        }
        if (randomLevel > level){
            this.level = randomLevel;
        }
    }

    //查找
    public SpikNode get(int value){
        SpikNode node = head;
        for (int i = this.level - 1; i >= 0; i--) {
            while (node.nexts[i] != null && node.nexts[i].value < value){
                node = node.nexts[i];
            }
        }
        if (node.nexts[0] != null && node.nexts[0].value == value){
            return node.nexts[0];
        }
        return null;
    }

    public boolean delete(int value){
        boolean falg = false;
        SpikNode node = head;
        SpikNode[] updateIndex = new SpikNode[level];
        for (int i = this.level - 1; i >= 0; i--) {
            while (node.nexts[i] != null && node.nexts[i].value < value){
                node = node.nexts[i];
            }
            if (node.nexts[i] != null && node.nexts[i].value == value){
                //记录前继节点
                updateIndex[i] = node;
            }
        }
        for (int i = 0; i < this.level; i++) {
            if (updateIndex[i] != null){
                updateIndex[i].nexts[i] = updateIndex[i].nexts[i].nexts[i];
                falg = true;
            }
        }
        return falg;
    }

    public void printAll() {
        SpikNode p = head;
        while (p.nexts[0] != null) {
            System.out.print(p.nexts[0] + " ");
            p = p.nexts[0];
        }
        System.out.println();
    }

    public SpikNode getHead() {
        return head;
    }
}
