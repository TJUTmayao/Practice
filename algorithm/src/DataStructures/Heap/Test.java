package DataStructures.Heap;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/2/4 10:39
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] array = {76,35,21,31,79,98,20,12,80,34,1,74,72,17,11,83,51,31,64,97,80,20,36,
                32,59,89,4,61,57,53,32,76,87,87,22,56,93,76,4,97,55,58,1,61,13,70,13,20,84,72};
//        int[] array = {5,6,2,4,9,3,1,8,7};
        HeapNode<String>[] nodes = new HeapNode[16];
        MyHeap<String> heap = new MyHeap<>(1);
        Random random = new Random();
        int j = 0;
        for (int i : array){
            heap.put(new HeapNode<>(i ,"M-" + j));
            j ++;
        }
//        for (int i = 0; i < 16; i++) {
//            nodes[i] = new HeapNode<>(random.nextInt(100) ,"M-" + i);
//        }

//        for (int i = 0; i < 16; i++) {
//            heap.put(new HeapNode<>(random.nextInt(100) ,"M-" + i));
//        }
        Map<Integer, HeapNode<String>> integerHeapNodeMap = heap.find(76);
        Set<Map.Entry<Integer, HeapNode<String>>> entries = integerHeapNodeMap.entrySet();
        for (Map.Entry<Integer, HeapNode<String>> entry : entries){
            System.out.println(entry.getKey() + "-->" + ((HeapNode<String>)entry.getValue()).key);
        }
//        heap.delete(76);
        heap.showAll();
        heap.sort();
        heap.showArray();
        System.out.println(heap.findNodeByKey(76,1));
        System.out.println(array.length + "--" + heap.getSize());
    }



}
