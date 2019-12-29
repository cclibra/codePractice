package othercode.LinkedList;

/**
 * 题目描述：
 * 给定一个单向链表的头节点 head，节点的值类型为整形，再给定一个整数 pivot。
 * 实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot 的节点，
 * 中间部分都是值等于 pivot 的节点，右部分都是值大于 pivot 的节点。
 * 在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左到右的顺序与原链表中节点的先后次序一致。
 * <p>
 * 思路：
 * 可以将链表中的所有节点放到一个额外数组中调整位置，但是需要占用O(n)的空间。
 * 可以将原链表中所有的节点依次划分为三个链表，三个链表分别为small代表左部分，equal代表中间部分，big代表右部分
 * 划分之后再将三个链表重新串起来即可。整个过程要注意对null节点的判断处理
 */
public class listPartitionPivot {
    public ListNode listPartition(ListNode head, int pivot) {
        //定义小的部分，相等部分和大的部分的头尾节点
        ListNode sH = null, sT = null, eH = null, eT = null, bH = null, bT = null;
        ListNode next = null;//保存下一个节点
        //所有的节点分到三个链表中
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                } else {
                    sT.next = head;
                }
                sT = head;
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            } else {
                if (bH == null) {
                    bH = head;
                } else {
                    bT.next = head;
                }
                bT = head;
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;//此处对eT做一个null判断,因为后面要连接eT
        }
        if (eT != null) {
            //eT不为空则连接bH，此时eT为空只可能sT为空且eT为空
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }
}
