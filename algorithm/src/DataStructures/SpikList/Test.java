package DataStructures.SpikList;

import java.util.Random;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/24 10:18
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        SpikList spikList = new SpikList();
        spikList.put(3);
        spikList.put(6);
        spikList.put(1);
        spikList.put(14);
        spikList.put(9);
        spikList.put(5);
        spikList.printAll();
        boolean isSort = true;
        SpikNode head = spikList.getHead();
        while (head.nexts[0] != null){
            if (head.value > head.nexts[0].value){
                isSort = false;
                break;
            }
            head = head.nexts[0];
        }
        System.out.println(isSort);
        System.out.println(spikList.delete(6));
        spikList.printAll();
        System.out.println(spikList.get(5));
    }
}
