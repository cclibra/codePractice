package leetcode.LinkedList;

/**
 * 题目描述：
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行正向排序。
 * <p>
 * 思路：
 * 对一个链表进行排序，且时间复杂度要求为 O(n log n) ，空间复杂度为常量。
 * 一看到 O(n log n) 的排序，首先应该想到归并排序和快速排序。
 * 利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方法是使用快慢指针法，找到中间位置，这样就分成了两段。
 * merge时，把两段头部节点值比较，用一个p指向较小的，且记录第一个节点，然后两段的头一步一步向后走，
 * p也一直向后走，总是指向较小节点，直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
 */
public class leetcode148_sortList {
    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head.next == null)
            return head;
        ListNode p = head, q = head, pre = null;
        //q为快指针，p保存中间节点或中间靠后节点，pre保存p的前一个节点
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode low = mergeSort(head);
        ListNode high = mergeSort(p);
        return merge(low, high);
    }

    ListNode merge(ListNode low, ListNode high) {
        ListNode dummyHead = new ListNode(0);//虚拟头节点，因为头节点不知道是在low中还是high中
        ListNode cur = dummyHead;
        while (low != null && high != null) {
            if (low.val <= high.val) {
                cur.next = low;
                cur = cur.next;
                low = low.next;
            } else {
                cur.next = high;
                cur = cur.next;
                high = high.next;
            }
        }
        if (low != null)
            cur.next = low;
        if (high != null)
            cur.next = high;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        leetcode148_sortList test = new leetcode148_sortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = test.sortList(head);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }
}
