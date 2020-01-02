package leetcode.LinkedList;


/**
 * 题目描述：
 * 给定一个链表，判断链表中是否有环。
 * 思路：
 * 使用快慢节点，如果链表无环，那么fast指针在移动过程中一定先遇到终点。
 * 如果链表有环，那么两指针一定会在环中某个位置相遇。当相遇时，fast指针若重回到head节点，slow不动。
 * 接下来fast指针从每次移动两步改为每次移动一步，slow指针依然每次移动一步。两指针一定会再次相遇，在第一个入环的节点处相遇。
 */
public class leetcode141_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode enterCycle = slow;//此时slow的位置为入环点的位置
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode141_hasCycle test = new leetcode141_hasCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        boolean res = test.hasCycle(head);
        System.out.println(res);
    }
}

