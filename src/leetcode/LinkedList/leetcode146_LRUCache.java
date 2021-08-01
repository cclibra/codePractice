package leetcode.LinkedList;

import java.util.HashMap;

/**
 * 题目描述：
 * 运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * <p>
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * <p>
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 争取在 O(1) 时间复杂度内完成这两种操作。
 * <p>
 * 思路：
 * 要让 put 和 get 方法的时间复杂度为 O(1)，可以得出cache 这个数据结构必要的条件：
 * 查找快，插入快，删除快，有顺序之分。
 * 因此选用哈希链表，它是双向链表和哈希表的结合体。
 */
class Node {
    public int key, val;
    public Node pre, next;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleListNode {
    int size = 0;
    Node head;
    Node last;

    //在链表头部添加节点x，用时O(1)
    public void addFirst(Node x) {
        if (this.head == null) {
            this.head = x;
            this.last = x;
        } else {
            Node tmp = this.head;
            tmp.pre = x;
            x.next = tmp;
            this.head = x;
        }
        size++;
    }

    //删除链表中的x节点(x一定存在)
    //在给定目标节点的情况下，用时O(1)
    public void remove(Node x) {
        if (x == this.head && x == this.last) {
            this.head = null;
            this.last = null;
        } else if (x == this.head) {
            this.head = head.next;
            this.head.pre = null;
        } else if (x == this.last) {
            this.last = x.pre;
            x.pre.next = null;
        } else {
            x.pre.next = x.next;
            x.next.pre = x.pre;
        }
        size--;
    }

    //删除链表中最后一个节点，并返回该节点，事件O(1)
    public Node removeLast() {
        Node node = this.last;
        remove(node);
        return node;
    }

    //返回链表的长度，时间O(1)
    public int size() {
        return this.size;
    }

}

public class leetcode146_LRUCache {
    //key映射到Node
    private final HashMap<Integer, Node> map;
    //存储Node
    private final DoubleListNode cache;
    //最大容量
    private final int cap;

    public leetcode146_LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleListNode();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            //此处直接调用put方法
            int val = map.get(key).val;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        //注意,key已经存在时,value不一定相等,要完成替换操作
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cache.size() == cap) {
                //此处删除链表最后一个数据节点，同时也要删除map对应的k-v
                //需要通过k进行连接，因此链表中应该同时存储key和val
                Node lastNode = cache.removeLast();
                map.remove(lastNode.key);
            }
        }
        cache.addFirst(node);
        //同时更新map中对应的数据
        map.put(key, node);
    }
}
