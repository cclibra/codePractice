package leetcode.TreeNode;

/**
 * 题目描述：
 * 翻转二叉树
 */
public class leetcode226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeNode(root);
        return root;
    }

    private void invertTreeNode(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
