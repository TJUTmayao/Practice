package DataStructures.Graph;

import Select.BFS.BFS;
import Select.DFS.DFS;

import java.util.Random;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/3/18 09:24
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph(false);
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            myGraph.add(i ,i + 2);
        }
        myGraph.relation(0,3);
        myGraph.relation(0,1);
        myGraph.relation(1,2);
        myGraph.relation(1,4);
        myGraph.relation(2,5);
        myGraph.relation(3,4);
        myGraph.relation(4,5);
        myGraph.relation(4,6);
        myGraph.relation(5,7);
        myGraph.relation(6,7);
        System.out.println();
//        DFS.search(myGraph,0,7);
        BFS.search(0,7,myGraph);
        myGraph.showAll();
    }
}
