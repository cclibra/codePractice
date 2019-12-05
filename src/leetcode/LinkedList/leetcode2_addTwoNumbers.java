package leetcode.LinkedList;

/**
 * 题目描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 思路：
 * 分别有两个指针遍历两个链表的每一位进行求和，设置一个进位标志，如果两位和上次的进位求和后需要进位，则将进位标志置为1.
 * 时间复杂度：O(\max(m, n))O(max(m,n))，
 * 假设 mm 和 nn 分别表示 l1l1 和 l2l2 的长度，上面的算法最多重复 \max(m, n)max(m,n) 次。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class leetcode2_addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode p = l1;
        ListNode q = l2;
        ListNode res = new ListNode(0);
        ListNode r = res;
        int flag = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + flag;
            r.next = new ListNode(sum % 10);
            flag = sum / 10;
            r = r.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (flag > 0)
            r.next = new ListNode(flag);
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
