package leetcode.LinkedList;

/**
 * 题目描述：
 * 反转单向链表
 * <p>
 * 思路：1.非递归方法，时间复杂度O(n),空间O(1)
 * 2.递归方法，每一次递归时间和空间都需要O(1)复杂度，所以总的时间和空间复杂度都为O(n)
 */
public class leetcode206_reverseList {
    //非递归方法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归方法,注意逐层传递的思想。需要传递到尾部，作为反转链表的新head作为最终返回；还要将需要反转的当前head与head.next进行反转
    //注意，反转过后，要赋head.next空值，不然会出现循环链表
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
