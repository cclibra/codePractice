package leetcode.LinkedList;

/**
 * 题目描述：
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * 示例:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 思路：
 * 遍历，若相连节点值不相同，则向下传递，若相连节点值相同，则维护一个pre节点值，遍历该段相同部分，获取第一个不相同的节点(可能为null)，
 * 将pre.next与该节点相连
 */
public class leetcode82_deleteAllDuplicatesList {
    public ListNode deleteAllDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        dummyHead.next = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (cur == null)
                    pre.next = null;
                else {
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        return dummyHead.next;
    }
}
