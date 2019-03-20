package DataStructures.HashTable;

/**
 * 说明：Hash表 + 双向链表  LinkedHashList模拟
 *
 * @Auther: 11432_000
 * @Date: 2019/1/26 09:06
 * @Description:
 */
public class MyHashTable<T> {
    /** 初始长度 */
    private static final int INIT_LENGTH = 16;
    /** 扩容阈值 */
    private static final double THRESHOLD = 1;
    /** 表长 */
    private int length;
    /** 元素个数 */
    private double size;
    /** 空链头 */
    private MyHashNode<T> head = new MyHashNode<>();
    /** 链尾 */
    private MyHashNode<T> end;
    /** 新hash表,链头为空 */
    private MyHashNode<T>[] newTable = new MyHashNode[INIT_LENGTH];
    /** 老hash表,链头为空 */
    private MyHashNode<T>[] oldTable;
    /** 旧表中的元素个数 */
    private int oldSize = 0;

    public MyHashTable() {
        this.length = INIT_LENGTH;
        this.end = this.head;
        for (int i = 0; i < this.length; i++) {
            newTable[i] = new MyHashNode<>();
        }
    }

    public int getHashValue(Object data ,int tableLength){
        int hashCode = data.hashCode();
        return (hashCode ^ (hashCode >>> 16)) & (tableLength - 1);
    }

    /** 获取目标元素在Hash表中的上一个 */
    private MyHashNode<T> getBeforeOnHash(T data ,MyHashNode<T>[] table){
        int hashValue = getHashValue(data ,table.length);
        MyHashNode node = table[hashValue];
        MyHashNode<T> beforeTarget = null;
        while (node.hashNext != null){
            if (data.equals(node.hashNext.data)){
                beforeTarget = node;
                break;
            }
            node = node.hashNext;
        }
        return beforeTarget;
    }

    /** 获取某个元素 */
    public MyHashNode<T> get(T data){
        MyHashNode<T> target = null;
        MyHashNode<T> beforeOnHash = getBeforeOnHash(data, this.newTable);
        if (beforeOnHash == null && this.oldSize != 0){
            getBeforeOnHash(data ,this.oldTable);
        }
        if (beforeOnHash != null){
            target = beforeOnHash.hashNext;
            deleteByLink(target);
            putOnLinkEnd(target);
        }
        return target;
    }

    /** 添加一个元素 */
    public void put(T data){
        //查找该元素的上一个元素是否存在
        MyHashNode<T> beforeOnHash = getBeforeOnHash(data ,this.newTable);
        if (beforeOnHash == null && this.oldSize != 0){
            beforeOnHash = getBeforeOnHash(data ,this.oldTable);
        }
        MyHashNode<T> tartget;
        //如果已经存在，放到链表为尾部
        if (beforeOnHash != null){
            tartget = beforeOnHash.hashNext;
            tartget = deleteByLink(tartget);
            putOnLinkEnd(tartget);
        }
        //如果是新节点
        else {
            if(this.size / this.length >= THRESHOLD){
                hashExpansion();
            }
            //每次从旧表搬移一个元素到新表，均摊扩容的消耗
            if (this.oldSize != 0){
                transferOneNode();
            }else {
                this.oldTable = null;
            }
            MyHashNode<T> newNode = new MyHashNode<T>();
            newNode.data = data;
            putOnLinkEnd(newNode);
            int hashValue = getHashValue(data,this.newTable.length);
            insertOnNewTable(newNode ,hashValue);
            size ++;
        }
    }

    /** 将一个元素插入到双向链表末尾 */
    private void putOnLinkEnd(MyHashNode<T> node){
        this.end.next = node;
        node.theLast = this.end;
        this.end = node;
    }

    /** 将一个元素插入到新Hash表中 */
    private void insertOnNewTable(MyHashNode<T> node ,int hashValue){
        MyHashNode<T> nullStart = this.newTable[hashValue];
        if (nullStart.hashNext != null){
            MyHashNode<T> hashNext = nullStart.hashNext;
            nullStart.hashNext = node;
            node.hashNext = hashNext;
        }else {
            nullStart.hashNext = node;
        }
    }

    /** 从Hash表删除某一个节点 */
    private MyHashNode<T> deleteByHash(MyHashNode<T> beforeTarget){
        MyHashNode<T> target = null;
        if (beforeTarget != null){
            target = beforeTarget.hashNext;
            beforeTarget.hashNext = target.hashNext;
            target.hashNext = null;
        }
        return target;
    }

    /**从链表删除某一个节点*/
    private MyHashNode<T> deleteByLink(MyHashNode<T> node){
        if (node == null){ return null; }
        if (node.theLast != null){
            node.theLast.next = node.next;
            if (node == this.end){
                this.end = node.theLast;
            }
        }
        if (node.next != null){
            node.next.theLast = node.theLast;
            if (node == this.end){
                this.end = node.next;
            }
        }
        node.next = node.theLast = null;
        return node;
    }

    /** 删除某个元素 */
    public void delete(T data){
        MyHashNode<T> beforeTarget = getBeforeOnHash(data ,this.newTable);
        if (beforeTarget == null && this.oldSize != 0){
            beforeTarget = getBeforeOnHash(data ,this.oldTable);
        }
        MyHashNode<T> myHashNode = deleteByHash(beforeTarget);
        deleteByLink(myHashNode);
        this.size --;
    }

    /** Hash表扩容 */
    private void hashExpansion(){
        this.oldTable = this.newTable;
        int newLength =(int) (this.length * 2);
        this.newTable = new MyHashNode[newLength];
        //初始化表头
        for (int i = 0; i < newLength; i++) {
            this.newTable[i] = new MyHashNode<T>();
        }
        this.length = newLength;
        this.oldSize =(int) this.size;
    }

    /** 将一个元素从旧表移动到新表 */
    private void transferOneNode(){
        MyHashNode<T> beforeTarget = null;
        MyHashNode<T> target;
        //从旧表取出一个元素
        beforeTarget = getOneByOldTable();
        //若旧表已空
        if (beforeTarget == null){
            this.oldSize = 0;
            return;
        }else {
            target = beforeTarget.hashNext;
            //从旧表中删除该元素
            deleteByHash(beforeTarget);
            //重新散列并插入新表
            int newHashValue = getHashValue(target.data ,this.newTable.length);
            insertOnNewTable(target ,newHashValue);
            this.oldSize --;
        }
    }

    /** 从旧表中获取一个元素 */
    private MyHashNode<T> getOneByOldTable(){
        boolean isFind = false;
        MyHashNode<T> beforeTarget;
        for (int i = 0; i < this.oldTable.length; i++) {
            beforeTarget = oldTable[i];
            if (beforeTarget.hashNext != null){
                isFind = true;
                while (beforeTarget.hashNext.hashNext != null){
                    beforeTarget = beforeTarget.hashNext;
                }
            }
            if (isFind){
                return beforeTarget;
            }
        }
        return null;
    }

    /** 显示链表 */
    public void showLink(){
        MyHashNode start = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        while (start.next != null){
            stringBuilder.append(start.next.data.toString() + ",");
            start = start.next;
        }
        if (stringBuilder.lastIndexOf(",") != -1){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder.toString());
    }

    /** 显示Hash表 */
    public void showHashTable(){
        MyHashNode start;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.oldSize != 0){
            System.out.println("-------OldTable--------");
            for (int i = 0; i < this.oldTable.length; i++) {
                start = this.oldTable[i];
                stringBuilder.delete(0,stringBuilder.length());
                stringBuilder.append("[");
                while (start.hashNext != null){
                    stringBuilder.append(start.hashNext.data + ",");
                    start = start.hashNext;
                }
                if (stringBuilder.lastIndexOf(",") != -1){
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                stringBuilder.append("]");
                System.out.println(stringBuilder);
            }
        }
        System.out.println("-------NewTable--------");
        for (int i = 0; i < this.newTable.length; i++) {
            start = this.newTable[i];
            stringBuilder.delete(0,stringBuilder.length());
            stringBuilder.append("[");
            while (start.hashNext != null){
                stringBuilder.append(start.hashNext.data + ",");
                start = start.hashNext;
            }
            if (stringBuilder.lastIndexOf(",") != -1){
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append("]");
            System.out.println(stringBuilder);
        }
    }

    public int getLength() {
        return length;
    }
}
