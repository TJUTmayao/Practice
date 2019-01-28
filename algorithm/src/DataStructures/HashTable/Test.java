package DataStructures.HashTable;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/1/28 10:57
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        MyHashTable<String> stringMyHashTable = new MyHashTable<>();
        for (int i = 0; i < 100; i++) {
//            System.out.print(stringMyHashTable.getHashValue("M-" + i ,32) + "\t");
            stringMyHashTable.put("M-" + i );
        }
        stringMyHashTable.showLink();
        stringMyHashTable.showHashTable();
//        System.out.println(stringMyHashTable.getLength());
        System.out.println(((MyHashNode)stringMyHashTable.get("M-16")).data);
    }
}
