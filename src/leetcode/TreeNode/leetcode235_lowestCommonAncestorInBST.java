package leetcode.TreeNode;

/**
 * 题目描述：
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 示例:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 思路：
 * 在条件是二叉搜索树的情况下，树节点的大小已经按照左小右大的顺序排列好。
 * 只需要将当前节点的值与两个目标值比对
 * 判断当前值是首次在两个值之间(包括)即可
 * 如果均大于或小于则往两边递归判断子节点
 */
public class leetcode235_lowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestorInBST(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestorInBST(root.left, p, q);
        return root;
    }
}
