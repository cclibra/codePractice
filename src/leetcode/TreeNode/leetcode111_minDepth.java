package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class leetcode111_minDepth {
    public int minDepth(TreeNode head) {
        return getDepth(head);
    }

    private int getDepth(TreeNode head) {
        if (head == null)
            return 0;
        int left = getDepth(head.left);
        int right = getDepth(head.right);
        return head.left == null || head.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
}
