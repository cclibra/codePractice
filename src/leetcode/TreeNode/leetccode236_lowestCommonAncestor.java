package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 思路：
 * 采用后向遍历，递归遍历整个二叉树，并从左右子树中返回给根节点值。
 * 假设遍历到的当前节点为cur。假设处理cur左子树时返回节点为left，处理右子树时返回right。
 * 1．如果发现cur等于null，或者o1、o2，则返回cur。
 * 2．如果left和right都为空，说明cur整棵子树上没有发现过o1或o2，返回null。
 * 3．如果left和right都不为空，说明左子树上发现过o1或o2，右子树上也发现过o2或o1，
 * 说明o1向上与o2向上的过程中，首次在cur相遇，返回cur。
 * 4．如果left和right有一个为空，另一个不为空，假设不为空的那个记为node，此时node到底是什么？
 * 有两种可能，要么node是o1或o2中的一个，要么node已经是o1和o2的最近公共祖先。
 * 不管是哪种情况，直接返回node即可。
 */
public class leetccode236_lowestCommonAncestor {
    private TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null || head == p || head == q)
            return head;
        TreeNode left = lowestCommonAncestor(head.left, p, q);
        TreeNode right = lowestCommonAncestor(head.right, p, q);
        if (left != null && right != null)
            return head;
        return left != null ? left : right;
    }

}
