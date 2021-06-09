package leetcode.LinkedList;


/**
 * 题目描述：
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例2：
 * 示例 2：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 思路：
 * 1. 非递归顺序。使用preHead保存头部节点。
 * 使用tmp向后遍历，交换tmp的下一个和下下个，直至这两个有一个为空。
 * 返回头节点。
 * <p>
 * 2.递归
 * 将递归函数看成对链表其中两个连续节点 head 和 next 的交换反转，返回反转后的头节点。
 * 然后本次反转后的next节点的next为递归一级的函数返回值。
 * 跳出条件为head或next为空。
 * 递归写法可分为从后往前返回head和从前往后设置next
 */
public class leetcode24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode tmp = preHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode pre = tmp.next;
            ListNode suf = tmp.next.next;
            pre.next = suf.next;
            suf.next = pre;
            tmp.next = suf;
            tmp = pre;
        }
        return preHead.next;
    }

    //从后往前依次返回反转后的头节点
    public ListNode swapPairsWithRecursive1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //先设置head.next为下一级递归返回的头节点
        //因为若先设置next.next为head后，后面节点会无节点指向
        head.next = swapPairsWithRecursive1(next.next);
        next.next = head;
        return next;
    }

    //从前往后依次设置next
    public ListNode swapPairsWithRecursive2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //保存后面的节点
        ListNode newNext = head.next.next;
        //设置新头部节点
        ListNode newHead = head.next;
        newHead.next = head;
        //设置反转后的后部节点连接为下一级递归返回的头部节点
        head.next = swapPairsWithRecursive2(newNext);
        return newHead;
    }

}
