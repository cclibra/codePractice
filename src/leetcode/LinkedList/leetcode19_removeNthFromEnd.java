package leetcode.LinkedList;

/**
 * 题目描述：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 给定的 n 保证是有效的。
 * <p>
 * 思路：使用双指针，快指针先行进n步，然后快慢指针一起行进，
 * 当快指针指向最后一个节点时，意味着慢指针的下一个节点是需要删除的节点。
 * 这里要注意保留删除前的节点，为了简化思路，可以开始时就创建一个带head前节点的链表，能够统一n为1时和链表总长度时两种极端情况
 */

public class leetcode19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0)
            return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p1 = res;
        ListNode p2 = res;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return res.next;
    }
}
