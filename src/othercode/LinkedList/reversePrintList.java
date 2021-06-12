package othercode.LinkedList;

import java.util.ArrayList;

/**
 * 题目描述：
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * <p>
 * 思路：
 * 通过递归的方式，先递推到尾部节点，然后再回溯返回过程中逐个添加到全局数组中
 * 获得添加的顺序，然后返回
 */
public class reversePrintList {
    int length = 0, j = 0;
    int[] res;

    public int[] reversePrint(ListNode head) {
        reverseListNode(head);
        return res;
    }

    //这里是递归阶段，注意，可以用ArrayList动态添加，这里为了一步到位添加到int[]中，
    //到尾节点时可以获得链表长度，从而建立该长度新数组
    //然后返回过程中逐个添加
    public void reverseListNode(ListNode head) {
        if (head == null) {
            res = new int[length];
            return;
        }
        length++;
        reverseListNode(head.next);
        res[j] = head.val;
        j++;
    }
}
