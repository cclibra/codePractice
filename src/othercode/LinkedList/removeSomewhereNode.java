package othercode.LinkedList;

/**
 * 题目描述：删除链表的中间节点 和a/b处的节点
 * 问题一：
 * 给定链表的头节点head，实现删除链表的中间节点的函数。
 * 例如：
 * 链表为空或长度为1，不删除任何节点；
 * 1 -> 2，删除节点1；
 * 1 -> 2 -> 3，删除节点2；
 * 1 -> 2 -> 3 -> 4，删除节点2；
 * 1 -> 2 -> 3 -> 4 -> 5，删除节点3；
 * <p>
 * 问题二：
 * 给定链表的头节点head、整数a和b，实现删除位于a/b处节点的函数。
 * 例如：
 * 链表：1 -> 2 -> 3 -> 4 -> 5，假设a/b的值为r。
 * 如果r等于0，不删除任何节点；
 * 如果r在区间(0，1/5]上，删除节点1；
 * 如果r在区间(1/5，2/5]上，删除节点2；
 * 如果r在区间(2/5，3/5]上，删除节点3；
 * 如果r在区间(3/5，4/5]上，删除节点4；
 * 如果r在区间(4/5，1]上，删除节点5；
 * 如果r大于1，不删除任何节点。
 * <p>
 * 思路：
 * 问题一：分析原问题，如果链表为空或者长度为1，不需要调整，则直接返回；
 * 如果链表的长度为2，将头节点删除即可；
 * 当链表长度到达3，应该删除第2个节点；
 * 当链表的长度为4，应该删除第2个节点；
 * 当链表的长度为5，应该删除第3个节点……
 * 也就是链表长度每增加2（3，5，7……），要删除的节点就后移一个节点。
 * <p>
 * 问题二：
 * 对于进阶问题，如何根据链表的长度n，以及a与b的值决定该删除的节点是哪一个节点。
 * 根据如下方法：先计算double r = ((double)(a*n)) / ((double)b)的值，
 * 然后r向上取整后的整数值代表该删除的节点是第几个节点。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class removeSomewhereNode {
    public ListNode removeMidNode(ListNode head) {
        //解决空head或单节点
        if (head == null || head.next == null) {
            return head;
        }
        //解决两个节点
        if (head.next.next == null) {
            return head.next;
        }
        ListNode pre = head;//这里注意，pre应该保留要删除节点的前一个节点
        ListNode cur = head.next.next;
        //在两个节点以上的情况下，在cur不前进或者前进一步时，pre无须移动，指的就是需删除节点的前一个节点
        //只有cur前进两次时，pre才需要移动一次，所以先保证pre移动完毕，用while循环实现
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        //删除pre后的节点
        pre.next = pre.next.next;
        return head;
    }

    public ListNode removeByRatio(ListNode head, int a, int b) {
        if (head == null || a < 1 || a > b) {
            return head;
        }
        int n = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        n = (int) Math.ceil((double) a * n / (double) b);//节省空间，直接将计算后待删除的节点次序赋值给长度n
        //直接处理删除头节点的情况
        if (n == 1)
            head = head.next;
        if (n > 1) {
            temp = head;
            //这里需要删除n处的节点，需要将temp定位到n-1处的节点，由于从head移动到n处需要n-1次，所以定位需要移动n-2次
            //首先想到在循环条件里直接判断n>2,也可以使用先递减n再判断条件的形式，这种可用于需要先递减计数值的情况
            while (--n > 1) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;

    }
}
