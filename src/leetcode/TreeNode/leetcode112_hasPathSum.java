package leetcode.TreeNode;

/**
 * 题目描述：
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * 思路：
 * 递归前序遍历，跳出条件是该节点为null时返回false。
 * 将给的目标值逐步与节点值相减，并判断该节点是否为叶子节点
 * 如果是叶子节点，判断此时sum是否减为0。是的话表明该路径和为sum，否的话则相反
 * 然后对左右子节点递归调用，并将结果用 或 相连
 */
public class leetcode112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
