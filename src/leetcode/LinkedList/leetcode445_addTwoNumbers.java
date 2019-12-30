package leetcode.LinkedList;

import java.util.Stack;

/**
 * 题目描述：
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 思路：
 * 1.可将两个链表反转，反转后低位在前，之后同leetcode2处理
 * 2.也可使用栈代替链表，压栈后弹出进行计算
 */
public class leetcode445_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode dummyHead = null;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int temp = stack1.pop() + stack2.pop() + flag;
            if (temp > 9) {
                temp = temp % 10;
                flag = 1;
            } else
                flag = 0;
            ListNode cur = new ListNode(temp);
            cur.next = dummyHead;
            dummyHead = cur;
        }
        Stack<Integer> stack = stack1.isEmpty() ? stack2 : stack1;
        while (!stack.isEmpty()) {
            int temp = stack.pop() + flag;
            if (temp > 9) {
                temp = temp % 10;
                flag = 1;
            } else
                flag = 0;
            ListNode cur = new ListNode(temp);
            cur.next = dummyHead;
            dummyHead = cur;
        }
        if (flag != 0) {
            ListNode cur = new ListNode(flag);
            cur.next = dummyHead;
            dummyHead = cur;
        }
        return dummyHead;
    }
}
