package DataStructures.Heap;

import java.util.*;

/**
 * 说明：大顶堆
 *
 * @Auther: 11432_000
 * @Date: 2019/2/4 09:27
 * @Description:
 */
public class MyHeap<T>{

    private HeapNode<T>[] tree;
    /** 树的大小 */
    private int length;
    /** 数组尾指针 */
    private int size;

    public MyHeap() {
        this.tree = new HeapNode[17];
        this.length = 16;
        this.size = 1;
    }

    public MyHeap(int size) {
        this.tree = new HeapNode[size + 1];
        this.length = size + 1;
        this.size = 1;
    }

    public MyHeap(HeapNode<T>[] array) {
        this.tree = new HeapNode[array.length + 1];
        System.arraycopy(array ,0,this.tree ,1,array.length);
        this.length = array.length;
        this.size = array.length;
        buildHeap(this.tree ,1 ,this.size);
    }
    /** 建堆 */
    private void buildHeap(HeapNode<T>[] tree ,int start ,int length) {
        int index = (int) Math.ceil(length / 2);
        //左右节点下标
        for (int i = index; i >= start; i--) {
            turnIntoHeap(i ,start + length - 1);
        }
    }
    /** 显示所有节点 */
    public void showAll(){
        for (int i = 1; i < this.size + 1; i++) {
            if (this.tree[i] == null){continue;}
            System.out.print(this.tree[i].key + "-->" + "\t");
            if (i * 2 < this.size + 1 && tree[i * 2] != null){
                System.out.print("左节点：" + this.tree[i * 2].key + "\t");
            }
            if (i * 2 + 1 < this.size + 1 && tree[i * 2 + 1] != null){
                System.out.print("右节点：" + this.tree[i * 2 + 1].key + "\t");
            }
            System.out.println();
        }
    }
    /** 插入一个新节点 */
    public void put(HeapNode newNode){
        if (this.size >= this.length) {
            expanded();
        }
        int newNodeIndex = this.size ++;
        int parentIndex;
        this.tree[newNodeIndex] = newNode;
        while (true){
            parentIndex = (newNodeIndex) / 2 ;
            if (parentIndex < 1){
                return;
            }
            else if (this.tree[parentIndex].key < this.tree[newNodeIndex].key){
                this.tree[newNodeIndex] = this.tree[parentIndex];
                this.tree[parentIndex] = newNode;
                newNodeIndex = parentIndex;
            }else {
                return;
            }
        }
    }
    /** 删除key对应的节点 */
    public void delete(int key){
        Map<Integer, HeapNode<T>> map = find(key);
        Set<Integer> keySet = map.keySet();
        int tail;
        int index;
       while ((index = findNodeByKey(key ,1)) >= 1){
           tail = this.size - 1;
           while (this.tree[tail] == null && tail >= 1){
               tail --;
           }
           this.tree[index] = this.tree[tail];
           this.tree[tail] = null;
           turnIntoHeap(index);
           this.size --;
       }
    }
    /** 查找节点 */
    public Map<Integer ,HeapNode<T>> find(int key){
        Map<Integer ,HeapNode<T>> map = new HashMap<>();
        findNodesByKey(key,map ,1);
        return map;
    }
    /** 根据key查找所有节点 */
    private void findNodesByKey(int key , Map<Integer ,HeapNode<T>> list ,int start){
        if (start >= size){return;}
        if ( this.tree[start] == null || this.tree[start].key < key){ return; }
        if (this.tree[start].key == key){
            list.put(start,this.tree[start]);
        }
        if(this.tree[start].key >= key){
            //遍历左子树
            findNodesByKey(key ,list ,(start * 2));
            //遍历右子树
            findNodesByKey(key ,list ,(start * 2 + 1));
        }
    }
    /** 根据key查找一个节点 */
    public int findNodeByKey(int key ,int start){
        if (start >= size){return -1;}
        if ( this.tree[start] == null || this.tree[start].key < key){ return -1; }
        if (this.tree[start].key == key){
            return start;
        }
        int left = findNodeByKey(key, start * 2);
        if (left != -1){return left;}
        int right = findNodeByKey(key, start * 2 + 1);
        return right;
    }
    public int getSize() {
        return size;
    }
    /** 扩容 */
    private void expanded(){
        int newLength = this.length * 2;
        HeapNode<T>[] newNodes = new HeapNode[newLength];
        System.arraycopy(this.tree , 0 , newNodes ,0,this.length);
        this.tree = newNodes;
        this.length = newLength;
    }
    /** 堆化 */
    private void turnIntoHeap(int index ,int max){
        int left, right;
        int maxIndex;
        HeapNode<T> casual;
        //保证每个节点大于等于其左右节点。
        while (true){
            left = index * 2 ;
            right = index * 2 + 1;
            maxIndex = index;
            //将当前节点与其左右节点比较,若左右节点大于该节点，则选择最大的节点与其交换
            if (tree[maxIndex] != null){
                if (left > this.size && right > this.size){
                    return;
                }
                if (tree[left] == null && tree[right] == null){return;}
                if (left < max + 1 && tree[left] != null){
                    if (tree[maxIndex].key < tree[left].key){
                        maxIndex = left;
                    }
                }
                if (right < max + 1 && tree[right] != null){
                    if (tree[maxIndex].key < tree[right].key){
                        maxIndex = right;
                    }
                }
                if (maxIndex != index){
                    casual = tree[maxIndex];
                    tree[maxIndex] = tree[index];
                    tree[index] = casual;
                    //指向原先的父节点
                    index = maxIndex;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
    }
    private void turnIntoHeap(int index){
        turnIntoHeap(index ,this.size);
    }
    /** 排序 */
    public  HeapNode<T>[] sort(){
        HeapNode<T>[] newTree = new HeapNode[this.tree.length];
        System.arraycopy(this.tree,0,newTree ,0 ,this.size);
        HeapNode<T> casual;
        //遍历堆
        for (int i = this.size - 1; i > 1 ; i--) {
            //交换堆顶和堆底元素
            casual = newTree[1];
            newTree[1] = newTree[i];
            newTree[i] = casual;
            //重新建堆
            buildHeap(newTree ,1 ,i - 1);
        }
        return newTree;
    }
    public void showArray(){
        for (int i = 1; i < this.size; i++) {
            System.out.print(this.tree[i].key +"\t");
        }
    }
}
