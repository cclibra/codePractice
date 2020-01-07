package othercode.LinkedList;

import java.util.HashSet;

/**
 * 题目描述：
 * 删除无序单链表中值重复出现的节点
 * 实例：
 * 输入: 1->1->2->3->3->1->2
 * 输出: 1->2->3
 * <p>
 * 不同于leetcode82和83，这里链表是无序的
 * 思路：
 * 1.利用哈希表，存放未重复节点，若有重复，则将节点删除。时间复杂度为O(N)，空间复杂度为O(N)。
 * 2.类似选择排序的过程，从头遍历每个节点，每次遍历时，从该节点嵌套再往后遍历一次，有重复值删除，时间复杂度为O(N^2)，空间复杂度为O(1)
 */
public class deleteDuplicatesListNoOrder {
    public ListNode deleteDuplicatesList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = head;
        ListNode cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
