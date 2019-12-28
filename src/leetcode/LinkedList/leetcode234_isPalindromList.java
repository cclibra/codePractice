package leetcode.LinkedList;

import java.util.Stack;

/**
 * 题目描述：
 * 给定一个链表的头节点head，请判断一个链表是否为回文链表。
 * 示例：
 * 输入: 1->2
 * 输出: false
 * 输入: 1->2->2->1
 * 输出: true
 * 思路：1.可将链表进行压栈，只压链表的右半部分，压入完成后，
 * 再检查栈顶到栈底值出现的顺序是否和链表左半部分的的值一致。
 * 时间复杂度为O(N)，空间复杂度为O(N)。
 * 2.可在空间复杂度为O(1)的条件下实现，即不需要额外的栈空间。对链表右半区直接反转。
 * 先用快慢节点找到中间节点的位置，然后将中间节点往后的链表进行反转，保存最后一个节点。
 * 最后将首位节点同时遍历比对数值，若均相等则证明是回文链表。
 */
public class leetcode234_isPalindromList {
    public boolean isPalindrom1(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode cur = head;
        ListNode right = head.next;
        //这里要让right指针指向中间节点后面的或者是靠后的那个节点，并不是最中间的节点，
        //所以这里初始化为head.next
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrom2(ListNode head) {
        if (head == null || head.next == null)
            return true;
        //先定位中间靠后的节点，即右部分第一个节点，使用slow和fast
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;//右部分第一个节点
        slow.next = null;
        ListNode next = null;
        //反转slow之后的链表，其中fast指向slow
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        ListNode tail = slow;//保存最后一个节点
        fast = head;//保存左边第一个节点
        boolean res = true;
        while (tail != null && fast != null) {
            if (tail.val != fast.val) {
                res = false;
                break;
            }
            tail.next = tail;
            fast.next = fast;
        }
        return res;
    }

    public boolean isPalindrom3(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        //边反转边移动链表，快慢指针定位，slow最终指向中间节点或中间靠前节点
        //用slow和fast去定位，反转使用prepre，pre和slow
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            slow.next = prepre;
            prepre = pre;
            fast = fast.next.next;
        }
        ListNode p2 = slow.next;//p2作为右半边的第一个节点
        slow.next = pre;
        ListNode p1 = fast == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
