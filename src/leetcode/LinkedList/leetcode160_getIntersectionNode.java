package leetcode.LinkedList;

/**
 * 题目描述：
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 思路：
 * 遍历两个链表，记录下两个链表的长度len1，len2和尾节点end1，end2。如果end1 == end2，证明两个链表相交。
 * 相交情况下，让较长的链表先走|len2-len1|步，然后两个链表一起走，第一个相同的节点就是相交的节点。
 * <p>
 * 优化：
 * 用cur1和cur2对两个链表head1和head2同时遍历，等遍历到某个短链表的末尾null时，比如是cur1，下一次遍历让cur1指向head2，
 * cur2不受影响继续遍历，等cur2遍历到长链表null时，下一次遍历让cur2指向head1，cur1不受影响。
 * 这样两个指针在走完之前均走了相同路程，如果相交，一定会有同时指向非null节点的时候。如果不相交则会同时指向各节点的null。
 */
public class leetcode160_getIntersectionNode {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int len1 = 0;
        int len2 = 0;
        while (cur1.next != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len2++;
            cur2 = cur2.next;
        }
        if (cur1 != cur2)
            return null;
        cur1 = len1 > len2 ? headA : headB;
        cur2 = cur1 == headA ? headB : headA;
        int n = Math.abs(len2 - len1);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
