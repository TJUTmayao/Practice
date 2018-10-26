package TestLinkedList;

import java.util.Scanner;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/18 15:57
 * @Description:
 */
public class TestMain {

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        String next;
        TestShow show = new TestShow() {
            @Override
            public void show(Object show) {
                Link link = (Link) show;
                do{
                    System.out.println(link.value);
                    link = link.nextLink;
                } while (link.nextLink != null);
            }
        };
        Link first = new Link();
        Link previous = first;
        do {
            next = sc.next();
            Link link = new Link();
            link.value = next;
            previous.nextLink = link;
            previous = link;
        }while (!"#".equals(next));
        show.show(first);
    }

    public static class Link {

        public String value;

        public Link nextLink;

    }
}
