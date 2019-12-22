package othercode.LinkedList;

/**
 * 背景：据说著名犹太历史学家Josephus有过如下故事：
 * 在罗马人占领乔塔帕特后，39个犹太人和Josephus及他的朋友躲进一个洞里，
 * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，
 * 41个人排成一个圆圈，由第一个人开始报数，报数到3的人就自杀，再由下一个人重新报1，报数到3的人就自杀，
 * 这样依次下去，知道剩下最后一个人时，那个人可以自由选择自己的命运。
 * 这就是著名的约瑟夫问题。
 * 现在请用单向链表描述该结构并呈现整个自杀过程。
 * <p>
 * 题目描述：
 * 输入：一个环形单向链表的头节点head和报数的值m
 * 返回：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉。
 * 要求：如果链表节点数为N，想在时间复杂度为O(N)时完成原问题。
 * <p>
 * 思路：可以仿照原问题描述，逐个删除掉每次报数的节点。没删除一个节点，都需要遍历m次，一共需要删除节点数为n-1，
 * 所以普通解法的时间复杂度为O(n*m)。
 * 要想在线性复杂度内完成，需要能根据节点个数直接确定最后剩下的节点是哪一个。（可画函数图，利用f(x)=x%N平移得到）
 * 首先,对于环形链表，有i个节点情况下，可以根据该节点报数求得该节点的编号：编号=（报数-1）%i+1
 * 在每一次删除节点中，删除编号为s的节点，删除前的老编号和删除后的新编号对应关系为：老编号=（新编号+s-1）%i+1
 * 这样，在每一次删除节点轮次中，因为被删除的编号为s的节点总是报数为m，则s=(m-1)%i+1，带入可得，
 * 老编号=（新编号+(m-1)%i）%i+1，进一步化简为老编号=（新编号+m-1）%i+1。
 * 至此，总体流程如下：
 * 1.遍历链表，求链表的节点数n，时间复杂度为O(N)
 * 2.根据n和m的值，递归地从单个节点求出老编号，递归为N层，时间复杂度为O(N)
 * 3.最后根据生存节点编号，遍历链表找出该节点，时间复杂度为O(N)
 * 4.过程结束，总的时间复杂度为O(N)
 */
public class josephusKillProblem {
    public ListNode josephusKill(ListNode head, int m) {
        if (head == null || head.next == null || m < 1)
            return head;
        int n = 1;
        ListNode cur = head;
        while (cur.next != head) {
            n++;
            cur = cur.next;
        }
        int kill = getLive(n, m);
        while (--kill != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public int getLive(int i, int m) {
        //i为该次环形链表的总节点数，m为报数的值，getLive返回被删节点上一次老编号的值
        if (i == 1)
            return 1;
        return (getLive(i - 1, m) + m - 1) % i + 1;//老编号=（新编号+m-1）%i+1,新编号处递归带入
    }

}
