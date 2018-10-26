package TestLinkedList;

import java.util.Scanner;

/**
 * 说明：链表中环的检测
 *
 * @Auther: 11432_000
 * @Date: 2018/10/20 15:26
 * @Description:
 */
public class RingCheck {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String string = sc.next();
        System.out.println("请输入环的入口：");
        int ring = sc.nextInt();
        char[] chars = string.toCharArray();
        int i = 0;
        RingLink head = new RingLink();
        RingLink first = head;
        RingLink huan = null;
        for (char ch : chars){
            RingLink newLink = new RingLink();
            first.put(ch ,newLink);
            first = newLink;
            i++;
            if (i == ring){
                huan = first;
            }
        }
        /* 连接环 */
        first.nextChar = huan;
        int i1 = checkRingIndex(head);
        System.out.println("环的入口在链表的第"+ i1 + "个元素。");
    }

    public static class RingLink{
        public char value;
        public RingLink nextChar;

        public void put(char value, RingLink nextChar){
            nextChar.value = value;
            this.nextChar = nextChar;
        }
    }

    /* 检测链表中环的入口 返回从表头开始第几个元素 若无环返回-1 */
    public static int checkRingIndex(RingLink head){
        RingLink p1,p2;
        p1 = p2 = head;
        int i = 0;
        do {
            p1 = p1.nextChar;
            p2 = p2.nextChar.nextChar;
        }while (p2 != null && p2.nextChar != null && p1 != p2);
        if (p2.nextChar == null){
            return -1;
        }
        p2 = head;
        do {
            p1 = p1.nextChar;
            p2 = p2.nextChar;
            i++;
        }while (p1 != p2);
        return i;
    }
}
