package leetcode.LinkedList;

import java.util.HashMap;

/**
 * 题目描述：
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。
 * <p>
 * 思路：
 * 1.直接利用HashMap保存各个节点的副本，保存完后，再进行一次遍历，从该Map中取出对应节点，然后再设置每个节点的next和rand。
 * 时间复杂度O(n),空间复杂度O(n)。
 * 2.若不用hash表保存对应关系，只用有限的几个变量完成。
 * 可在第一次遍历链表的时候，在每个节点cur后面和cur.next之前插入该节点的复制节点copy。
 * 第二次遍历，在遍历时设置每一个副节点的指针，设置的方法是根据原节点cur的rand指针cur.rand，则副节点cur.next的rand
 * 就是cur.rand.next（要注意判空）。然后再将两个链表分离。
 */
class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode rand;

    RandomListNode(int x) {
        val = x;
    }
}

public class leetcode138_copyRandomList {
    //HashMap方法
    public RandomListNode copyRandomList1(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //复制节点法
    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode cur = head;
        RandomListNode next = null;
        //遍历，复制每个节点的副本在该节点的后面,next指cur的副本
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        //遍历，为每个节点副本设置rand值
        while (cur != null) {
            next = cur.next;
            next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next.next;
        }

        cur = head;
        RandomListNode res = head.next;
        //遍历，拆分成两个链表
        while (cur != null) {
            next = cur.next;
            cur.next = next == null ? null : next.next;
            cur = cur.next;
        }
        return res;
    }
}
