package leetcode.LinkedList;

/**
 * 题目描述：
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * 示例1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例2：
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * <p>
 * 示例3：
 * 输入：head = [1], k = 1
 * 输出：[1]
 * <p>
 * 思路：
 * 主要是找到正数第k个节点和倒数第k个节点。
 * 倒数第k个节点使用双快慢指针，相隔k个后，快指针到尾节点后，慢指针自然为倒数第k个。
 */
public class leetcode1721_swapNodes {
    public ListNode swapNodesIndexK(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode suf;
        ListNode tmp;
        int j = 0;
        while (j < k && pre != null) {
            j++;
            pre = pre.next;
        }
        if (pre == null) {
            return null;
        }
        tmp = pre;
        suf = preHead;
        while (tmp != null) {
            tmp = tmp.next;
            suf = suf.next;
        }
        int swapTmp = 0;
        swapTmp = suf.val;
        suf.val = pre.val;
        pre.val = swapTmp;
        return head;
    }
}
