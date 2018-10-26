package TestLinkedList;

import java.util.Scanner;

/**
 * 说明：链表回文检测
 *
 * @Auther: 11432_000
 * @Date: 2018/10/18 16:36
 * @Description:
 */
public class TestPalindrome {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String palindrome = sc.next();
        char[] chars = palindrome.toCharArray();
        CharLink first = new CharLink();
        CharLink previous = first;
        for (char ca : chars){
            CharLink link = new CharLink();
            previous.put(ca ,link);
            previous = link;
        }
//        do {
//            first = first.nextChar;
//            System.out.println(first.value);
//        }while (first.nextChar != null);
        palindromeCheck(first);
    }

    public static class CharLink{
        public char value;
        public CharLink nextChar;

        public void put(char value, CharLink nextChar){
            nextChar.value = value;
            this.nextChar = nextChar;
        }
    }

    public static boolean palindromeCheck(CharLink first){
        CharLink fast,slow,slowNext,slowNow,midpoint;
        fast = slow = first;
        slowNext = fast.nextChar;
        while (fast.nextChar != null && fast.nextChar.nextChar != null){
            fast = fast.nextChar.nextChar;
            slowNow = slow;
            slow = slowNext;
            slowNext = slow.nextChar;
            slow.nextChar = slowNow;
            if (first.nextChar != null){
                first.nextChar = null;
            }
        }
        midpoint = slow;
        do {
            System.out.println(midpoint.value);
            midpoint = midpoint.nextChar;
        }while (midpoint.nextChar != null);
        do {
            System.out.println(slowNext.value);
            slowNext = slowNext.nextChar;
        }while (slowNext != null);
        return false;
    }
}
