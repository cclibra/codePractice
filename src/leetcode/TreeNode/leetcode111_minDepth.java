package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 递归：当节点为空时，跳出递归。
 * 每次需要做的就是计算左右节点的深度，然后将较小的值+1作为深度返回。
 * 这里要注意，如果左右节点有空值，应该讲两部分求和，不应该将较小的0值返回
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
