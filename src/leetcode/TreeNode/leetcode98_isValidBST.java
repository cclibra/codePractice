package leetcode.TreeNode;

/**
 * 题目描述：
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 思路：
 * 采用递归，比较根节点和左右节点值得大小，递归调用。
 * 要注意，要保证根节点左边所有的节点值都要小于根节点值，因此对于左边来说，要传递该节点值作为较大边界。
 * 右边同理，传递该节点值作为较小边界。
 */
public class leetcode98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;
        if (!isValid(root.left, low, root.val)) return false;
        if (!isValid(root.right, root.val, high)) return false;
        return true;
    }
}
