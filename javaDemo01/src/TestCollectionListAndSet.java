import java.util.*;

/**
 * 说明：list和set，以及Collections和Arrays的工具方法，以及重写hashCode()和equals()方法，
 * 以及自定义类的排序的实现（Comparable）
 *
 * @Auther: 11432_000
 * @Date: 2018/10/16 13:07
 * @Description:
 */
public class TestCollectionListAndSet {

    /* 想要比较两个对象是否相同，需要重写equals和hashcode方法
    *  想要排序，想要实现Comparable或Comparator接口
    * */
    public static void main(String[] arg){
        String[] strings = {"mayao", "liuzhilei","545454","545455","545454s"};
        /* list 有序，可重复  ArrayList为有序数组 LinkedList为链表 */
        List<String> list = new ArrayList<String>();
        /* 将数组转换为list 使用Arrays工具的方法asList() */
        List<String> asList = Arrays.asList(strings);
        /* 将其他集合（collection子类）的内容全部添加到list中 */
        list.addAll(asList);
        /* 在指定位置插入 */
        list.add(0,"maguodong");
        /* 替换指定位置元素 */
        list.set(1,"mayaonb");
        /* 删除元素 */
        list.remove(1);
        /* 删除和指定集合内元素相同的元素 */
//        list.removeAll(Arrays.asList(strings));
        /* 使用迭代器输出list */
        /*for (String s : list){
            System.out.println((String) s);
        }*/
        /* 判断list是否包含指定对象/多个对象 */
        Collections.sort(list);
        boolean mayaonb = list.contains("maguodong");
        boolean b = list.containsAll(list);
        System.out.println(mayaonb);
        show(list);


        /* set 无序 不可重复 集合 代表：HashSet 多次添加同一个对象只保留最后添加的 */
        Set<Stu> set = new HashSet<>();
        TestCollectionListAndSet listAndSet = new TestCollectionListAndSet();
        Stu stu = listAndSet.new Stu();
        Stu stu2 = listAndSet.new Stu();
        stu.setId("123");
        stu.setName("mayao");
        stu2.setId("123");
        stu2.setName("mayao");

        System.out.println(stu.hashCode() + " " + stu2.hashCode());
        /* 遍历只可以用foreach和Iterator */
        set.add(stu);
//        stu.setId("2015");
        set.add(stu2);
        /* 想要比较两个对象是否相同，必须重写equals和hashcode方法 Collection的实现类都是 */
       System.out.println(set.contains(stu2));
        showSet(set);
    }

    public static void show(List list){
        Iterator iterator = list.iterator();
        System.out.println(list.size());
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void showSet(Set list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Stu next = (Stu) iterator.next();
            System.out.println(next.getId() + "名字是：" + next.getName());
        }
    }
    public class Stu implements Comparable{

        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        /* 重写equals和hashCode */
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (!(o instanceof Stu)) {return false;}
            Stu stu = (Stu) o;
            return Objects.equals(name, stu.name) &&
                    Objects.equals(id, stu.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        /* 根据id排序 */
        public int compareTo(Object o) {
            return this.id.compareTo(((Stu)o).getId());
        }
    }
}
