package othercode.LinkedList;

class DoubleListNode {
    public int value;
    public DoubleListNode last;
    public DoubleListNode next;

    public DoubleListNode(int data) {
        this.value = data;
    }
}

public class reverseDoubleList {
    public DoubleListNode reverseDoubleListNode(DoubleListNode head) {
        if (head == null)
            return head;
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
