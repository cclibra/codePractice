package leetcode.LinkedList;

/**
 * 题目描述：
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 思路：
 * 和单链表反转类似，也有迭代和递归的方法实现
 * 迭代：遍历到 m 位置节点，反转后面的节点，反转时相当于反转 m 到 n 的单链表，将反转后的尾节点连接到 n+1节点
 * 递归：
 */
public class leetcode92_reverseBetweenList {
    public ListNode reverseBetweenList(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, cur = head;
        //prev指的是m节点的前一个节点,cur是m处的节点
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        //将m处前一个节点保存为con，m节点保存为tail
        ListNode con = prev, tail = cur, third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        //反转后，prev指向n处节点，cur和third指向n处下一个节点
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}
