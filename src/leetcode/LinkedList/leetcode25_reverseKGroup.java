package leetcode.LinkedList;

/**
 * 题目描述：
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * <p>
 * 思路：
 * 可以使用栈结构，每K个进行压栈，然后以此弹出重新连接，每组逆序完成需要记录下头节点的位置和尾节点，但需要O(N)时间复杂度和O(N)空间复杂度
 * 若实现常数的空间复杂度，不使用栈结构，在原链表中直接调整。
 * 主要分为两个部分：遍历部分和反转部分。遍历主要是记录第一次k段的头尾值和后面k段的头位置(第一次要特殊处理)。反转部分就是对每一次
 * k段的链表进行反转，入参是本段链表的头尾值和本段的前后节点。
 */
public class leetcode25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        //cur为遍历当前值，start记录当需要反转k长度链表时，反转前的开始节点，反转前该段的前后节点为pre和next，反转前的尾节点为cur
        ListNode cur = head, start = null, pre = null, next;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == k) {
                //这里start和head值要注意第一段k反转和后面的反转有不同
                //start要赋值反转前的节点，因为要输入到反转函数中，head要赋值反转后的节点，因为要记录最终的头节点
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;//注意，新反转后的链表头节点，为第一次k段反转前的尾节点，即遍历到当前的cur
                resign(pre, start, cur, next);
                pre = start;//注意反转后反转部分的尾节点为start
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public void resign(ListNode left, ListNode start, ListNode end, ListNode right) {
        ListNode pre = start, cur = start.next, next;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }
}