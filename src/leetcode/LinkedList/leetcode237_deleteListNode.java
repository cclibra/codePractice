package leetcode.LinkedList;

/**
 * 题目描述：
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 示例：
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 思路：
 * 该题其实直接指定了链表中需要删除的节点Node，其实直接处理Node前后的节点就可以。
 * 由于不知道Node的pre节点，所以这里转换思路，复制Node的next节点到Node，然后删除next节点，变相地删除Node节点
 */
public class leetcode237_deleteListNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
