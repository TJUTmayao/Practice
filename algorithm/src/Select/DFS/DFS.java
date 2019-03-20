package Select.DFS;

import DataStructures.Graph.GraphNode;
import DataStructures.Graph.MyGraph;

import java.util.ArrayList;

/**
 * 说明：深度优先搜索
 *
 * @Auther: 11432_000
 * @Date: 2019/3/19 14:42
 * @Description:
 */
public class DFS {
    private static  Stack<Integer> stack;

    public static void search(MyGraph graph ,int begin ,int end){
        stack = new Stack<>(graph.getSize());
        int beginIndex = graph.findNodeIndex(begin);
        DFS(graph ,beginIndex ,end ,"");
    }

    private static void DFS(MyGraph graph, int beginIndex ,int end ,String path){
        GraphNode node = graph.getNode(beginIndex);
        if (node != null){
            if (node.key == end){
                System.out.println(path + end);
                return;
            }
            stack.push(beginIndex);
            path = path + beginIndex  + "-->" ;
            GraphNode next = node;
            while (next.next != null){
                next = next.next;
                int nodeIndex = graph.findNodeIndex(next.key);
                if (stack.isHave(nodeIndex)){continue;}
                DFS(graph ,nodeIndex,end ,path);
            }
            stack.out();
        }
    }
}


/** 临时栈 */
class Stack<T>{
    private Object[] array;
    private int top;
    private int size;
    private boolean isNull = true;

    public Stack(int size) {
        this.array = new Object[size];
        this.top = 0;
        this.size = size;
    }

    public Stack() {
        this.array = new Object[16];
        this.top = 0;
        this.size = 16;
    }

    public void push(T data){
        if (top >= this.size){
            throw new RuntimeException("数组越界异常");
        }
        if (top == 0 && isNull){
            this.array[top] = data;
        }else {
            this.array[(++top)] = data;
        }
        this.isNull = false;
    }

    public T out(){
        if (top == 0 && !isNull){
            return null;
        }
        if (top == 0){
            isNull = true;
            return (T)array[top];
        }else {
            return (T)array[top --];
        }
    }

    public boolean isHave(T data){
        for (int i = this.top; i >= 0; i--) {
            if (data == this.array[i]){
                return true;
            }
        }
        return false;
    }

}
