package Select.BFS;

import DataStructures.Graph.GraphNode;
import DataStructures.Graph.MyGraph;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 说明：广度优先搜索算法
 *
 * @Auther: 11432_000
 * @Date: 2019/3/18 10:53
 * @Description:
 */
public class BFS {

    /** 搜索 */
    public static void search(int startIndex , int endIndex, MyGraph graph){
        //队列，存储已被访问但其连接的节点未被访问。
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(startIndex);
        //标识已访问节点
        boolean visits[] = new boolean[graph.getSize()];
        visits[startIndex] = true;
        //存储访问路径
        Set<Integer>[] lists = new Set[graph.getSize() + 1];
        while (!queue.isEmpty()){
            //取出一个节点
            Integer poll = queue.poll();
            GraphNode node = graph.getNode(poll);
            //标记该节点已被访问
            visits[poll] = true;
            //如果该节点有相连的节点
            while (node.next != null){
                int nodeIndex = graph.findNodeIndex(node.next.key);
                //该节点被访问且与其相连的的节点没有被访问，将该节带放到相连节点的前驱节点集合中
                if (!visits[nodeIndex] && nodeIndex != poll && visits[poll]){
                    if (lists[nodeIndex] == null){
                        lists[nodeIndex] = new HashSet<>();
                    }
                    lists[nodeIndex].add(poll);
                }
                //如果该节点未被访问并且不在队列中
                if (!visits[nodeIndex] && ((LinkedList<Integer>) queue).indexOf(nodeIndex) == -1){
                    //将该节点添加到队列
                    ((LinkedList<Integer>) queue).add(nodeIndex);
                }
                node = node.next;
            }
        }
        show(lists,startIndex,endIndex,new StringBuilder(),null);
    }

    private static void show(Set<Integer>[] sets,int strat ,int end,StringBuilder stringBuilder ,Iterator<Integer> iterator){
        if(strat != end){

            if (iterator != null && iterator.hasNext()){
                show(sets,strat,iterator.next(),new StringBuilder(stringBuilder),null);
                show(sets,strat,end,new StringBuilder(stringBuilder),iterator);
            }
            if (sets[end] != null && !sets[end].isEmpty()){
                stringBuilder.append(end + "-->");
               if (iterator == null){
                   iterator = sets[end].iterator();
                   show(sets,strat,end,new StringBuilder(stringBuilder),iterator);
               }
            }
        }else {
            stringBuilder.append(strat);
            System.out.println(stringBuilder);
        }
    }

}
